package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.blogdtos.BlogHomeDto;
import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import finalproject.az.farmfresh.models.Blog;
import finalproject.az.farmfresh.models.CategoryBlog;
import finalproject.az.farmfresh.services.BlogService;
import finalproject.az.farmfresh.services.CategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryBlogService categoryBlogService;
    @GetMapping("/blog")
    public String index(Model model)
    {
        List<CategoryBlogDto> categoryBlogs=categoryBlogService.getAllBlogCategories();
        List<BlogHomeDto> homeBlogs=blogService.getHomeBlogs();
        model.addAttribute("blogs", homeBlogs);
        model.addAttribute("categoryBlogs", categoryBlogs);
        return "blog";
    }

}
