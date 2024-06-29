package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.factdtos.*;
import finalproject.az.farmfresh.dtos.productdtos.ProductDetailDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductHomeDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductUpdateDto;
import finalproject.az.farmfresh.models.CategoryProduct;
import finalproject.az.farmfresh.models.Fact;
import finalproject.az.farmfresh.models.Product;
import finalproject.az.farmfresh.repositories.FactRepository;
import finalproject.az.farmfresh.services.FactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactServiceImpl implements FactService {

    @Autowired
    private FactRepository factRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<FactDto> getFacts() {
        List<FactDto> factDtoList=factRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(fact->modelMapper.map(fact, FactDto.class))
                .collect(Collectors.toList());
        return factDtoList;
    }

    @Override
    public void addFact(FactCreateDto factDto) {
        try{
            Fact fact = new Fact();
            fact.setName(factDto.getName());
            fact.setNumber(factDto.getNumber());
            fact.setIconClass(factDto.getIconClass());
            fact.setIsDeleted(false);
            factRepository.save(fact);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<FactHomeDto> getHomeFacts() {
        List<FactHomeDto> factDtoList = factRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(fact -> modelMapper.map(fact, FactHomeDto.class))
                .collect(Collectors.toList());
        return factDtoList;
    }

    @Override
    public void updateFact(FactUpdateDto factDto) {
        Fact findFact = factRepository.findById(factDto.getId()).orElseThrow();
        findFact.setId(factDto.getId());
        findFact.setName(factDto.getName());
        findFact.setNumber(factDto.getNumber());
        findFact.setIconClass(factDto.getIconClass());
        factRepository.saveAndFlush(findFact);
    }

    @Override
    public FactUpdateDto findUpdateFact(Long id) {
        Fact fact = factRepository.findById(id).orElseThrow();
        FactUpdateDto factUpdateDto = modelMapper.map(fact, FactUpdateDto.class);
        return factUpdateDto;
    }

    @Override
    public FactDetailDto factDetail(Long id) {
        Fact fact = factRepository.findById(id).orElseThrow();
        FactDetailDto factUpdateDto = modelMapper.map(fact,FactDetailDto.class);
        return factUpdateDto;
    }

    @Override
    public void removeFact(Long factId) {
        Fact fact = factRepository.findById(factId).orElseThrow();
        fact.setIsDeleted(true);
        factRepository.save(fact);
    }
}
