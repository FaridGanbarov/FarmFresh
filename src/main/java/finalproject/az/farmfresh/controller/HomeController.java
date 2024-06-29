package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.aboutusdtos.AboutUsHomeDto;
import finalproject.az.farmfresh.dtos.bannerdtos.BannerHomeDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogHomeDto;
import finalproject.az.farmfresh.dtos.factdtos.FactHomeDto;
import finalproject.az.farmfresh.dtos.featuredtos.FeatureHomeDto;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmHomeDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductHomeDto;
import finalproject.az.farmfresh.dtos.teammemberdtos.TeamMemberHomeDto;
import finalproject.az.farmfresh.dtos.testimonialdtos.TestimonialHomeDto;
import finalproject.az.farmfresh.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TeamMemberService teamMemberService;

    @Autowired
    private TestimonialService testimonialService;

    @Autowired
    private AboutUsService aboutUsService;

    @Autowired
    private FactService factService;

    @Autowired
    private OrganicFarmService organicFarmService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private BannerService bannerService;

    @GetMapping("/")
    public String index(Model model)
    {
        List<BlogHomeDto> homeBlogs=blogService.getHomeBlogs();
        model.addAttribute("blogs", homeBlogs);
        List<ProductHomeDto> products =productService.getHomeProducts();
        model.addAttribute("products", products);
        List<TeamMemberHomeDto> homeTeamMembers = teamMemberService.getHomeTeamMembers();
        model.addAttribute("teamMembers", homeTeamMembers);
        List<TestimonialHomeDto> homeTestimonials = testimonialService.getHomeTestimonials();
        model.addAttribute("testimonials", homeTestimonials);
        List<AboutUsHomeDto> homeAboutUses = aboutUsService.getHomeAboutUses();
        model.addAttribute("aboutUses", homeAboutUses);
        List<FactHomeDto> homeFacts = factService.getHomeFacts();
        model.addAttribute("facts", homeFacts);
        List<OrganicFarmHomeDto> homeOrganicFarms = organicFarmService.getHomeOrganicFarms();
        model.addAttribute("organicFarms", homeOrganicFarms);
        List<FeatureHomeDto> homeFeatures = featureService.getHomeFeatures();
        model.addAttribute("features", homeFeatures);
        List<BannerHomeDto> homeBanners = bannerService.getHomeBanners();
        model.addAttribute("banners", homeBanners);
        return "home";
    }
}
