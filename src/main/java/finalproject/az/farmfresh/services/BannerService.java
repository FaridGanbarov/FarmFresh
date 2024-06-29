package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.bannerdtos.*;

import finalproject.az.farmfresh.models.Banner;

import java.util.List;

public interface BannerService {
    List<BannerDto> getBanners();
    void addBanner(BannerCreateDto bannerDto);
    List<BannerHomeDto> getHomeBanners();
    void updateBanner(BannerUpdateDto bannerDto);
    BannerUpdateDto findUpdateBanner(Long id);
    BannerDetailDto bannerDetail(Long id);
    void removeBanner(Long bannerId);
}
