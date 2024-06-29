package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.featuredtos.*;
import finalproject.az.farmfresh.models.Feature;

import java.util.List;

public interface FeatureService {
    List<FeatureDto> getFeatures();
    void addFeature(FeatureCreateDto featureDto);
    List<FeatureHomeDto> getHomeFeatures();
    void updateFeature(FeatureUpdateDto featureDto);
    FeatureUpdateDto findUpdateFeature(Long id);
    FeatureDetailDto featureDetail(Long id);
    void removeFeature(Long featureId);
}
