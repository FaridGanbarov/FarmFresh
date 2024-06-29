package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.featuredtos.*;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmDetailDto;
import finalproject.az.farmfresh.models.Feature;
import finalproject.az.farmfresh.models.OrganicFarm;
import finalproject.az.farmfresh.repositories.FeatureRepository;
import finalproject.az.farmfresh.services.FeatureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<FeatureDto> getFeatures() {
        List<FeatureDto> featureDtoList=featureRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(feature->modelMapper.map(feature, FeatureDto.class))
                .collect(Collectors.toList());
        return featureDtoList;
    }

    @Override
    public void addFeature(FeatureCreateDto featureDto) {
        try{
            Feature feature = new Feature();
            feature.setTitle(featureDto.getTitle());
            feature.setSubTitle(featureDto.getSubTitle());
            feature.setIconClass(featureDto.getIconClass());
            feature.setIsDeleted(false);
            featureRepository.save(feature);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<FeatureHomeDto> getHomeFeatures() {
        List<FeatureHomeDto> featureDtoList = featureRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(feature -> modelMapper.map(feature, FeatureHomeDto.class))
                .collect(Collectors.toList());
        return featureDtoList;
    }

    @Override
    public void updateFeature(FeatureUpdateDto featureDto) {
        Feature findFeature = featureRepository.findById(featureDto.getId()).orElseThrow();
        findFeature.setId(featureDto.getId());
        findFeature.setTitle(featureDto.getTitle());
        findFeature.setSubTitle(featureDto.getSubTitle());
        findFeature.setIconClass(featureDto.getIconClass());
        featureRepository.saveAndFlush(findFeature);
    }

    @Override
    public FeatureUpdateDto findUpdateFeature(Long id) {
        Feature feature = featureRepository.findById(id).orElseThrow();
        FeatureUpdateDto featureUpdateDto = modelMapper.map(feature, FeatureUpdateDto.class);
        return featureUpdateDto;
    }

    @Override
    public FeatureDetailDto featureDetail(Long id) {
        Feature feature = featureRepository.findById(id).orElseThrow();
        FeatureDetailDto featureUpdateDto = modelMapper.map(feature,FeatureDetailDto.class);
        return featureUpdateDto;
    }

    @Override
    public void removeFeature(Long featureId) {
        Feature feature = featureRepository.findById(featureId).orElseThrow();
        feature.setIsDeleted(true);
        featureRepository.save(feature);
    }
}
