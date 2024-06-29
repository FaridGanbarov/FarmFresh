package finalproject.az.farmfresh.services.impl;


import finalproject.az.farmfresh.dtos.bannerdtos.*;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmDetailDto;
import finalproject.az.farmfresh.models.Banner;
import finalproject.az.farmfresh.models.OrganicFarm;
import finalproject.az.farmfresh.repositories.BannerRepository;
import finalproject.az.farmfresh.services.BannerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BannerDto> getBanners() {
        List<BannerDto> bannerDtoList =bannerRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(banner->modelMapper.map(banner, BannerDto.class))
                .collect(Collectors.toList());
        return bannerDtoList;
    }

    @Override
    public void addBanner(BannerCreateDto bannerDto) {
        try{
            Banner banner = new Banner();
            banner.setTitle(bannerDto.getTitle());
            banner.setSubTitle(bannerDto.getSubTitle());
            banner.setIsDeleted(false);
            bannerRepository.save(banner);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<BannerHomeDto> getHomeBanners() {
        List<BannerHomeDto> bannerDtoList = bannerRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(banner -> modelMapper.map(banner, BannerHomeDto.class))
                .collect(Collectors.toList());
        return bannerDtoList;
    }

    @Override
    public void updateBanner(BannerUpdateDto bannerDto) {
        Banner findBanner = bannerRepository.findById(bannerDto.getId()).orElseThrow();
        findBanner.setId(bannerDto.getId());
        findBanner.setTitle(bannerDto.getTitle());
        findBanner.setSubTitle(bannerDto.getSubTitle());
        bannerRepository.saveAndFlush(findBanner);
    }

    @Override
    public BannerUpdateDto findUpdateBanner(Long id) {
        Banner banner = bannerRepository.findById(id).orElseThrow();
        BannerUpdateDto bannerUpdateDto = modelMapper.map(banner, BannerUpdateDto.class);
        return bannerUpdateDto;
    }

    @Override
    public BannerDetailDto bannerDetail(Long id) {
        Banner banner = bannerRepository.findById(id).orElseThrow();
        BannerDetailDto bannerUpdateDto = modelMapper.map(banner,BannerDetailDto.class);
        return bannerUpdateDto;
    }

    @Override
    public void removeBanner(Long bannerId) {
        Banner banner = bannerRepository.findById(bannerId).orElseThrow();
        banner.setIsDeleted(true);
        bannerRepository.save(banner);
    }
}
