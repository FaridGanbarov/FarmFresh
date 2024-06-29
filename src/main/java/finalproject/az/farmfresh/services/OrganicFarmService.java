package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.organicfarmdtos.*;

import java.util.List;

public interface OrganicFarmService {
    List<OrganicFarmDto> getOrganicFarms();
    void addOrganicFarm(OrganicFarmCreateDto organicFarmDto);
    List<OrganicFarmHomeDto> getHomeOrganicFarms();
    void updateOrganicFarm(OrganicFarmUpdateDto organicFarmDto);
    OrganicFarmUpdateDto findUpdateOrganicFarm(Long id);
    OrganicFarmDetailDto organicFarmDetail(Long id);
    void removeOrganicFarm(Long organicFarmId);
}
