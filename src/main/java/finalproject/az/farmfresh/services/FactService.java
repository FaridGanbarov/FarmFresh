package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.factdtos.*;


import java.util.List;

public interface FactService {
    List<FactDto> getFacts();
    void addFact(FactCreateDto factDto);
    List<FactHomeDto> getHomeFacts();
    void updateFact(FactUpdateDto factDto);
    FactUpdateDto findUpdateFact(Long id);
    FactDetailDto factDetail(Long id);
    void removeFact(Long factId);
}
