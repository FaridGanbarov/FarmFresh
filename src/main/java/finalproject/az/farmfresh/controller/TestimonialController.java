package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.testimonialdtos.TestimonialHomeDto;
import finalproject.az.farmfresh.services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;
    @GetMapping("/testimonial")
    public String index(Model model)
    {
        List<TestimonialHomeDto> homeTestimonials = testimonialService.getHomeTestimonials();
        model.addAttribute("testimonials", homeTestimonials);
        return "testimonial";
    }
}
