package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.factdtos.FactDetailDto;
import finalproject.az.farmfresh.dtos.factdtos.FactUpdateDto;
import finalproject.az.farmfresh.dtos.organicfarmdtos.*;
import finalproject.az.farmfresh.models.Fact;
import finalproject.az.farmfresh.models.OrganicFarm;
import finalproject.az.farmfresh.repositories.OrganicFarmRepository;
import finalproject.az.farmfresh.services.OrganicFarmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganicFarmServiceImpl implements OrganicFarmService {

    @Autowired
    private OrganicFarmRepository organicFarmRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<OrganicFarmDto> getOrganicFarms() {
        List<OrganicFarmDto> organicFarmDtoList=organicFarmRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(organicFarm->modelMapper.map(organicFarm, OrganicFarmDto.class))
                .collect(Collectors.toList());
        return organicFarmDtoList;
    }

    @Override
    public void addOrganicFarm(OrganicFarmCreateDto organicFarmDto) {
        try{
            OrganicFarm organicFarm = new OrganicFarm();
            organicFarm.setTitle(organicFarmDto.getTitle());
            organicFarm.setSubTitle(organicFarmDto.getSubTitle());
            organicFarm.setIconClass(organicFarmDto.getIconClass());
            organicFarm.setIsDeleted(false);
            organicFarmRepository.save(organicFarm);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<OrganicFarmHomeDto> getHomeOrganicFarms() {
        List<OrganicFarmHomeDto> organicFarmDtoList = organicFarmRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(organicFarm -> modelMapper.map(organicFarm, OrganicFarmHomeDto.class))
                .collect(Collectors.toList());
        return organicFarmDtoList;
    }

    @Override
    public void updateOrganicFarm(OrganicFarmUpdateDto organicFarmDto) {
        OrganicFarm findOrganicFarm = organicFarmRepository.findById(organicFarmDto.getId()).orElseThrow();
        findOrganicFarm.setId(organicFarmDto.getId());
        findOrganicFarm.setTitle(organicFarmDto.getTitle());
        findOrganicFarm.setSubTitle(organicFarmDto.getSubTitle());
        findOrganicFarm.setIconClass(organicFarmDto.getIconClass());
        organicFarmRepository.saveAndFlush(findOrganicFarm);
    }

    @Override
    public OrganicFarmUpdateDto findUpdateOrganicFarm(Long id) {
        OrganicFarm organicFarm = organicFarmRepository.findById(id).orElseThrow();
        OrganicFarmUpdateDto organicFarmUpdateDto = modelMapper.map(organicFarm, OrganicFarmUpdateDto.class);
        return organicFarmUpdateDto;
    }

    @Override
    public OrganicFarmDetailDto organicFarmDetail(Long id) {
        OrganicFarm organicFarm = organicFarmRepository.findById(id).orElseThrow();
        OrganicFarmDetailDto organicFarmUpdateDto = modelMapper.map(organicFarm,OrganicFarmDetailDto.class);
        return organicFarmUpdateDto;
    }

    @Override
    public void removeOrganicFarm(Long organicFarmId) {
        OrganicFarm organicFarm = organicFarmRepository.findById(organicFarmId).orElseThrow();
        organicFarm.setIsDeleted(true);
        organicFarmRepository.save(organicFarm);
    }
}
