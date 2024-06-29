package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.featuredtos.FeatureHomeDto;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmHomeDto;
import finalproject.az.farmfresh.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FeatureController {
    @Autowired
    private FeatureService featureService;
    @GetMapping("/feature")
    public String index(Model model)
    {
        List<FeatureHomeDto> homeFeatures = featureService.getHomeFeatures();
        model.addAttribute("features", homeFeatures);
        return "feature";
    }
}
