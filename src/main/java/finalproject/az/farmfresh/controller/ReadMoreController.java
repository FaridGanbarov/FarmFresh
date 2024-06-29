package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.bannerdtos.BannerHomeDto;
import finalproject.az.farmfresh.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReadMoreController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/readVegetables")
    public String readveg(Model model)
    {
        List<BannerHomeDto> homeBanners = bannerService.getHomeBanners();
        model.addAttribute("banners", homeBanners);
        return "readVegetables";
    }


    @GetMapping("/readFruits")
    public String readfru(Model model)
    {
        List<BannerHomeDto> homeBanners = bannerService.getHomeBanners();
        model.addAttribute("banners", homeBanners);
        return "readFruits";
    }
}
