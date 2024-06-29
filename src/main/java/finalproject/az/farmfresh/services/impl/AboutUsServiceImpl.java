package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.aboutusdtos.*;
import finalproject.az.farmfresh.dtos.blogdtos.BlogDetailDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogUpdateDto;
import finalproject.az.farmfresh.models.AboutUs;
import finalproject.az.farmfresh.models.Blog;
import finalproject.az.farmfresh.repositories.AboutUsRepository;
import finalproject.az.farmfresh.services.AboutUsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    private AboutUsRepository aboutUsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<AboutUsDto> getAboutUses() {
        List<AboutUsDto> aboutUsDtoList=aboutUsRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(aboutUs->modelMapper.map(aboutUs, AboutUsDto.class))
                .collect(Collectors.toList());
        return aboutUsDtoList;
    }

    @Override
    public void addAboutUs(AboutUsCreateDto aboutUsDto) {
        try{
            AboutUs aboutUs = new AboutUs();
            aboutUs.setTitle(aboutUsDto.getTitle());
            aboutUs.setPhotoUrl(aboutUsDto.getPhotoUrl());

            aboutUs.setIsDeleted(false);
            aboutUs.setWinning(aboutUsDto.getWinning());
            aboutUs.setSubTitle(aboutUsDto.getSubTitle());
            aboutUs.setOrganic(aboutUsDto.getOrganic());

            aboutUsRepository.save(aboutUs);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<AboutUsHomeDto> getHomeAboutUses() {
        List<AboutUsHomeDto> aboutUsDtoList = aboutUsRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(aboutUs -> modelMapper.map(aboutUs, AboutUsHomeDto.class))
                .collect(Collectors.toList());
        return aboutUsDtoList;
    }

    @Override
    public void updateAboutUs(AboutUsUpdateDto aboutUsDto) {
        AboutUs findAboutUs = aboutUsRepository.findById(aboutUsDto.getId()).orElseThrow();
        findAboutUs.setId(aboutUsDto.getId());
        findAboutUs.setTitle(aboutUsDto.getTitle());
        findAboutUs.setWinning(aboutUsDto.getWinning());
        findAboutUs.setOrganic(aboutUsDto.getOrganic());
        findAboutUs.setPhotoUrl(aboutUsDto.getPhotoUrl());
        findAboutUs.setSubTitle(aboutUsDto.getSubTitle());
        aboutUsRepository.saveAndFlush(findAboutUs);
    }

    @Override
    public AboutUsUpdateDto findUpdateAboutUs(Long id) {
        AboutUs aboutUs = aboutUsRepository.findById(id).orElseThrow();
        AboutUsUpdateDto aboutUsUpdateDto = modelMapper.map(aboutUs, AboutUsUpdateDto.class);
        return aboutUsUpdateDto;
    }

    @Override
    public AboutUsDetailDto aboutUsDetail(Long id) {
        AboutUs aboutUs = aboutUsRepository.findById(id).orElseThrow();
        AboutUsDetailDto aboutUsUpdateDto = modelMapper.map(aboutUs,AboutUsDetailDto.class);
        return aboutUsUpdateDto;
    }

    @Override
    public void removeAboutUs(Long aboutUsId) {
        AboutUs aboutUs = aboutUsRepository.findById(aboutUsId).orElseThrow();
        aboutUs.setIsDeleted(true);
        aboutUsRepository.save(aboutUs);
    }
}
