package finalproject.az.farmfresh.services;



import finalproject.az.farmfresh.dtos.aboutusdtos.*;

import java.util.List;

public interface AboutUsService {
    List<AboutUsDto> getAboutUses();
    void addAboutUs(AboutUsCreateDto aboutUsDto);
    List<AboutUsHomeDto> getHomeAboutUses();
    void updateAboutUs(AboutUsUpdateDto aboutUsDto);
    AboutUsUpdateDto findUpdateAboutUs(Long id);
    AboutUsDetailDto aboutUsDetail(Long id);
    void removeAboutUs(Long aboutUsId);
}
