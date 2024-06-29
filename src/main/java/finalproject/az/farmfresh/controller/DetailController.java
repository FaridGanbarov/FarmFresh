package finalproject.az.farmfresh.controller;

import finalproject.az.farmfresh.dtos.blogdtos.BlogDetailDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogHomeDto;
import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import finalproject.az.farmfresh.services.BlogService;
import finalproject.az.farmfresh.services.CategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DetailController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryBlogService categoryBlogService;

    @GetMapping("/detail/{id}")
    public String index(@PathVariable Long id, Model model)
    {
        List<CategoryBlogDto> categoryBlogs=categoryBlogService.getAllBlogCategories();
        model.addAttribute("categoryBlogs", categoryBlogs);
        BlogDetailDto blogDetail=blogService.blogDetail(id);
        model.addAttribute("blog", blogDetail);
        List<BlogHomeDto> homeBlogs=blogService.getHomeBlogs();
        model.addAttribute("blogs", homeBlogs);;
        return "detail";
    }

}
