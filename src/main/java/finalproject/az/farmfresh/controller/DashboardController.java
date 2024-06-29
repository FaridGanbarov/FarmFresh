package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.aboutusdtos.AboutUsCreateDto;
import finalproject.az.farmfresh.dtos.aboutusdtos.AboutUsDto;
import finalproject.az.farmfresh.dtos.aboutusdtos.AboutUsUpdateDto;
import finalproject.az.farmfresh.dtos.bannerdtos.BannerCreateDto;
import finalproject.az.farmfresh.dtos.bannerdtos.BannerDto;
import finalproject.az.farmfresh.dtos.bannerdtos.BannerUpdateDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogCreateDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogUpdateDto;
import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryCreateBlogDto;
import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryCreateProductDto;
import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryProductDto;
import finalproject.az.farmfresh.dtos.factdtos.FactCreateDto;
import finalproject.az.farmfresh.dtos.factdtos.FactDto;
import finalproject.az.farmfresh.dtos.factdtos.FactUpdateDto;
import finalproject.az.farmfresh.dtos.featuredtos.FeatureCreateDto;
import finalproject.az.farmfresh.dtos.featuredtos.FeatureDto;
import finalproject.az.farmfresh.dtos.featuredtos.FeatureUpdateDto;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmCreateDto;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmDto;
import finalproject.az.farmfresh.dtos.organicfarmdtos.OrganicFarmUpdateDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductCreateDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductUpdateDto;
import finalproject.az.farmfresh.dtos.roledtos.RoleDto;
import finalproject.az.farmfresh.dtos.teammemberdtos.TeamMemberCreateDto;
import finalproject.az.farmfresh.dtos.teammemberdtos.TeamMemberDto;
import finalproject.az.farmfresh.dtos.teammemberdtos.TeamMemberUpdateDto;
import finalproject.az.farmfresh.dtos.testimonialdtos.TestimonialCreateDto;
import finalproject.az.farmfresh.dtos.testimonialdtos.TestimonialDto;
import finalproject.az.farmfresh.dtos.testimonialdtos.TestimonialUpdateDto;
import finalproject.az.farmfresh.dtos.userdtos.UserAddRoleDto;
import finalproject.az.farmfresh.dtos.userdtos.UserDashboardListDto;
import finalproject.az.farmfresh.dtos.userdtos.UserDto;
import finalproject.az.farmfresh.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private CategoryBlogService categoryBlogService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CategoryProductService categoryProductService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BlogService blogService;

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

    @GetMapping("/admin")
    public String index()
    {
        return "/dashboard/home";
    }

    @GetMapping("/admin/category-blog")
    public String categoryBlog(Model model)
    {
        List<CategoryBlogDto> categoryBlogs = categoryBlogService.getAllBlogCategories();
        model.addAttribute("categoryBlogs", categoryBlogs);
        return "/dashboard/category-blog";
    }

    @GetMapping("/admin/category-blog/category-blog-create")
    public String addBlogCategory()
    {
        return "/dashboard/category-blog-create";
    }

    @PostMapping("/admin/category-blog/create")
    public String addBlogCategory(@ModelAttribute CategoryCreateBlogDto categoryCreateBLogDto)
    {
        categoryBlogService.add(categoryCreateBLogDto);
        return "redirect:/admin/category-blog";
    }

    @GetMapping("/admin/category-product")
    public String categoryProduct(Model model)
    {
        List<CategoryProductDto> categoryProducts = categoryProductService.getAllProductCategories();
        model.addAttribute("categoryProducts", categoryProducts);
        return "/dashboard/category-product";
    }

    @GetMapping("/admin/category-product/category-product-create")
    public String addProductCategory()
    {
        return "/dashboard/category-product-create";
    }

    @PostMapping("/admin/category-product/create")
    public String addProductCategory(@ModelAttribute CategoryCreateProductDto categoryCreateProductDto)
    {
        categoryProductService.add(categoryCreateProductDto);
        return "redirect:/admin/category-product";
    }


    @GetMapping("/admin/users")
    public String getUsers(Model model)
    {
        List<UserDashboardListDto> userList=userService.getDashboardUsers();
        model.addAttribute("users",userList);
        return "/dashboard/auth/user-list";
    }
    @GetMapping("/admin/users/role/{id}")
    public String addRole(@PathVariable Long id, Model model)
    {
        List<RoleDto> roles=roleService.getRoles();
        UserDto user=userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("roles",roles);
        return "/dashboard/auth/user-role";
    }
    @PostMapping("/admin/users/addrole")
    public String addRole(UserAddRoleDto addRoleDto)
    {
        userService.addRole(addRoleDto);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/blog")
    public String blogGet(Model model)
    {
        List<BlogDto> blogs=blogService.getBlogs();
        model.addAttribute("blogs",blogs);
        return "/dashboard/blog";
    }

    @GetMapping("/admin/blog/create")
    public String blogCreate(Model model)
    {
        List<CategoryBlogDto> categoryBlogs=categoryBlogService.getAllBlogCategories();
        model.addAttribute("categoryBlogs",categoryBlogs);
        model.addAttribute("blog", new BlogCreateDto());
        return "/dashboard/blog-create";
    }

    @PostMapping("/admin/blog/create")
    public String blogCreate(@ModelAttribute BlogCreateDto blogDto)
    {
        blogService.addBlog(blogDto);
        return "redirect:/admin/blog";
    }

    @GetMapping("/admin/blog/remove/{id}")
    public String removeBlog(@ModelAttribute @PathVariable Long id)
    {
        blogService.removeBlog(id);
        return "redirect:/admin/blog";
    }

    @GetMapping("/admin/blog/update/{id}")
    public String updateBlog(@ModelAttribute @PathVariable Long id, Model model)
    {
        BlogUpdateDto blogUpdateDto=blogService.findUpdateBlog(id);
        List<CategoryBlogDto> categoryBlogs = categoryBlogService.getAllBlogCategories();
        model.addAttribute("categoryBlogs", categoryBlogs);
        model.addAttribute("blog",blogUpdateDto);
        return "/dashboard/blog/update";
    }
    @PostMapping("admin/blog/update")
    public String updateBlog(@ModelAttribute BlogUpdateDto blogUpdateDto)
    {
        blogService.updateBlog(blogUpdateDto);
        return "redirect:/admin/blog";
    }


    @GetMapping("/admin/product")
    public String productGet(Model model)
    {
        List<ProductDto> products=productService.getProducts();
        model.addAttribute("products",products);
        return "/dashboard/product";
    }
    @GetMapping("/admin/product/create")
    public String productCreate(Model model)
    {
        List<CategoryProductDto> categoryProducts=categoryProductService.getAllProductCategories();
        model.addAttribute("categoryProducts",categoryProducts);
        model.addAttribute("product", new ProductCreateDto());
        return "/dashboard/product-create";
    }
    @PostMapping("/admin/product/create")
    public String productCreate(@ModelAttribute ProductCreateDto productDto)
    {
        productService.addProduct(productDto);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/remove/{id}")
    public String removeProduct(@ModelAttribute @PathVariable Long id)
    {
        productService.removeProduct(id);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@ModelAttribute @PathVariable Long id, Model model)
    {
        ProductUpdateDto productUpdateDto=productService.findUpdateProduct(id);
        List<CategoryProductDto> categoryProducts = categoryProductService.getAllProductCategories();
        model.addAttribute("categoryProducts", categoryProducts);
        model.addAttribute("product",productUpdateDto);
        return "/dashboard/product/update";
    }
    @PostMapping("admin/product/update")
    public String updateProduct(@ModelAttribute ProductUpdateDto productUpdateDto)
    {
        productService.updateProduct(productUpdateDto);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/teamMember")
    public String teamMemberGet(Model model)
    {
        List<TeamMemberDto> teamMembers=teamMemberService.getTeamMembers();
        model.addAttribute("teamMembers",teamMembers);
        return "/dashboard/teamMember";
    }

    @GetMapping("/admin/teamMember/create")
    public String teamMemberCreate(Model model)
    {
        model.addAttribute("teamMember", new TeamMemberCreateDto());
        return "/dashboard/teamMember-create";
    }

    @PostMapping("/admin/teamMember/create")
    public String teamMemberCreate(@Valid @ModelAttribute("teamMember") TeamMemberCreateDto teamMemberDto, BindingResult result,Model model)
    {
        if (result.hasErrors()) {
            return "dashboard/teamMember-create";
        }
        try {
            teamMemberService.addTeamMember(teamMemberDto);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "dashboard/teamMember-create";
        }
        return "redirect:/admin/teamMember";
    }

    @GetMapping("/admin/teamMember/remove/{id}")
    public String removeTeamMember(@ModelAttribute @PathVariable Long id)
    {
        teamMemberService.removeTeamMember(id);
        return "redirect:/admin/teamMember";
    }

    @GetMapping("/admin/teamMember/update/{id}")
    public String updateTeamMember( @ModelAttribute @PathVariable Long id, Model model)
    {
        TeamMemberUpdateDto teamMemberUpdateDto=teamMemberService.findUpdateTeamMember(id);
        model.addAttribute("teamMember",teamMemberUpdateDto);
        return "/dashboard/teamMember/update";
    }
    @PostMapping("admin/teamMember/update")
    public String updateTeamMember(@Valid @ModelAttribute("teamMember") TeamMemberUpdateDto teamMemberUpdateDto,BindingResult result,Model model)
    {
        if (result.hasErrors()) {
            return "dashboard/teamMember/update";
        }
        try {
            teamMemberService.updateTeamMember(teamMemberUpdateDto);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "dashboard/teamMember/update";
        }
        return "redirect:/admin/teamMember";
    }

    @GetMapping("/admin/testimonial")
    public String testimonialGet(Model model)
    {
        List<TestimonialDto> testimonials =testimonialService.getTestimonials();
        model.addAttribute("testimonials", testimonials);
        return "/dashboard/testimonial";
    }

    @GetMapping("/admin/testimonial/create")
    public String testimonialCreate(Model model)
    {
        model.addAttribute("testimonial", new TestimonialCreateDto());
        return "/dashboard/testimonial-create";
    }
    @PostMapping("/admin/testimonial/create")
    public String testimonialCreate(@Valid @ModelAttribute("testimonial") TestimonialCreateDto testimonialDto, BindingResult result,Model model)
    {
        if (result.hasErrors()) {
            return "dashboard/testimonial-create";
        }
        try {
            testimonialService.addTestimonial(testimonialDto);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "dashboard/testimonial-create";
        }
        return "redirect:/admin/testimonial";
    }
    @GetMapping("/admin/testimonial/remove/{id}")
    public String removeTestimonial(@ModelAttribute @PathVariable Long id)
    {
        testimonialService.removeTestimonial(id);
        return "redirect:/admin/testimonial";
    }
    @GetMapping("/admin/testimonial/update/{id}")
    public String updateTestimonial(@ModelAttribute @PathVariable Long id, Model model)
    {
        TestimonialUpdateDto testimonialUpdateDto=testimonialService.findUpdateTestimonial(id);
        model.addAttribute("testimonial",testimonialUpdateDto);
        return "/dashboard/testimonial/update";
    }
    @PostMapping("admin/testimonial/update")
    public String updateTestimonial(@Valid @ModelAttribute("testimonial") TestimonialUpdateDto testimonialUpdateDto,BindingResult result,Model model)
    {
        if (result.hasErrors()) {
            return "dashboard/testimonial/update";
        }
        try {
            testimonialService.updateTestimonial(testimonialUpdateDto);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "dashboard/testimonial/update";
        }
        return "redirect:/admin/testimonial";
    }

    @GetMapping("/admin/aboutUs")
    public String aboutUsGet(Model model)
    {
        List<AboutUsDto> aboutUses =aboutUsService.getAboutUses();
        model.addAttribute("aboutUses", aboutUses);
        return "/dashboard/aboutUs";
    }
    @GetMapping("/admin/aboutUs/create")
    public String aboutUsCreate(Model model)
    {
        model.addAttribute("aboutUs", new AboutUsCreateDto());
        return "/dashboard/aboutUs-create";
    }
    @PostMapping("/admin/aboutUs/create")
    public String aboutUsCreate(@ModelAttribute AboutUsCreateDto aboutUsDto)
    {
        aboutUsService.addAboutUs(aboutUsDto);
        return "redirect:/admin/aboutUs";
    }

    @GetMapping("/admin/aboutUs/remove/{id}")
    public String removeAboutUs(@ModelAttribute @PathVariable Long id)
    {
        aboutUsService.removeAboutUs(id);
        return "redirect:/admin/aboutUs";
    }

    @GetMapping("/admin/aboutUs/update/{id}")
    public String updateAboutUs(@ModelAttribute @PathVariable Long id, Model model)
    {
        AboutUsUpdateDto aboutUsUpdateDto=aboutUsService.findUpdateAboutUs(id);
        model.addAttribute("aboutUs",aboutUsUpdateDto);
        return "/dashboard/aboutUs/update";
    }
    @PostMapping("admin/aboutUs/update")
    public String updateAboutUs(@ModelAttribute AboutUsUpdateDto aboutUsUpdateDto)
    {
        aboutUsService.updateAboutUs(aboutUsUpdateDto);
        return "redirect:/admin/aboutUs";
    }
    @GetMapping("/admin/fact")
    public String factGet(Model model)
    {
        List<FactDto> facts=factService.getFacts();
        model.addAttribute("facts",facts);
        return "/dashboard/fact";
    }
    @GetMapping("/admin/fact/create")
    public String factCreate(Model model)
    {
        model.addAttribute("fact", new FactCreateDto());
        return "/dashboard/fact-create";
    }
    @PostMapping("/admin/fact/create")
    public String factCreate(@ModelAttribute FactCreateDto factDto)
    {
        factService.addFact(factDto);
        return "redirect:/admin/fact";
    }
    @GetMapping("/admin/fact/remove/{id}")
    public String removeFact(@ModelAttribute @PathVariable Long id)
    {
        factService.removeFact(id);
        return "redirect:/admin/fact";
    }
    @GetMapping("/admin/fact/update/{id}")
    public String updateFact(@ModelAttribute @PathVariable Long id, Model model)
    {
        FactUpdateDto factUpdateDto=factService.findUpdateFact(id);
        model.addAttribute("fact",factUpdateDto);
        return "/dashboard/fact/update";
    }
    @PostMapping("admin/fact/update")
    public String updateFact(@ModelAttribute FactUpdateDto factUpdateDto)
    {
        factService.updateFact(factUpdateDto);
        return "redirect:/admin/fact";
    }


    @GetMapping("/admin/organicFarm")
    public String organicFarmGet(Model model)
    {
        List<OrganicFarmDto> organicFarms=organicFarmService.getOrganicFarms();
        model.addAttribute("organicFarms",organicFarms);
        return "/dashboard/organicFarm";
    }
    @GetMapping("/admin/organicFarm/create")
    public String organicFarmCreate(Model model)
    {
        model.addAttribute("organicFarm", new OrganicFarmCreateDto());
        return "/dashboard/organicFarm-create";
    }
    @PostMapping("/admin/organicFarm/create")
    public String organicFarmCreate(@ModelAttribute OrganicFarmCreateDto organicFarmDto)
    {
        organicFarmService.addOrganicFarm(organicFarmDto);
        return "redirect:/admin/organicFarm";
    }
    @GetMapping("/admin/organicFarm/remove/{id}")
    public String removeOrganicFarm(@ModelAttribute @PathVariable Long id)
    {
        organicFarmService.removeOrganicFarm(id);
        return "redirect:/admin/organicFarm";
    }
    @GetMapping("/admin/organicFarm/update/{id}")
    public String updateOrganicFarm(@ModelAttribute @PathVariable Long id, Model model)
    {
        OrganicFarmUpdateDto organicFarmUpdateDto =organicFarmService.findUpdateOrganicFarm(id);
        model.addAttribute("organicFarm", organicFarmUpdateDto);
        return "/dashboard/organicFarm/update";
    }
    @PostMapping("admin/organicFarm/update")
    public String updateOrganicFarm(@ModelAttribute OrganicFarmUpdateDto organicFarmUpdateDto)
    {
        organicFarmService.updateOrganicFarm(organicFarmUpdateDto);
        return "redirect:/admin/organicFarm";
    }


    @GetMapping("/admin/feature")
    public String featureGet(Model model)
    {
        List<FeatureDto> features=featureService.getFeatures();
        model.addAttribute("features",features);
        return "/dashboard/feature";
    }
    @GetMapping("/admin/feature/create")
    public String featureCreate(Model model)
    {
        model.addAttribute("feature", new FeatureCreateDto());
        return "/dashboard/feature-create";
    }
    @PostMapping("/admin/feature/create")
    public String featureCreate(@ModelAttribute FeatureCreateDto featureDto)
    {
        featureService.addFeature(featureDto);
        return "redirect:/admin/feature";
    }
    @GetMapping("/admin/feature/remove/{id}")
    public String removeFeature(@ModelAttribute @PathVariable Long id)
    {
        featureService.removeFeature(id);
        return "redirect:/admin/feature";
    }
    @GetMapping("/admin/feature/update/{id}")
    public String updateFeature(@ModelAttribute @PathVariable Long id, Model model)
    {
        FeatureUpdateDto featureUpdateDto =featureService.findUpdateFeature(id);
        model.addAttribute("feature", featureUpdateDto);
        return "/dashboard/feature/update";
    }
    @PostMapping("admin/feature/update")
    public String updateFeature(@ModelAttribute FeatureUpdateDto featureUpdateDto)
    {
        featureService.updateFeature(featureUpdateDto);
        return "redirect:/admin/feature";
    }

    @GetMapping("/admin/banner")
    public String bannerGet(Model model)
    {
        List<BannerDto> banners=bannerService.getBanners();
        model.addAttribute("banners",banners);
        return "/dashboard/banner";
    }
    @GetMapping("/admin/banner/create")
    public String bannerCreate(Model model)
    {
        model.addAttribute("banner", new BannerCreateDto());
        return "/dashboard/banner-create";
    }
    @PostMapping("/admin/banner/create")
    public String bannerCreate(@ModelAttribute BannerCreateDto bannerDto)
    {
        bannerService.addBanner(bannerDto);
        return "redirect:/admin/banner";
    }
    @GetMapping("/admin/banner/remove/{id}")
    public String removeBanner(@ModelAttribute @PathVariable Long id)
    {
        bannerService.removeBanner(id);
        return "redirect:/admin/banner";
    }
    @GetMapping("/admin/banner/update/{id}")
    public String updateBanner(@ModelAttribute @PathVariable Long id, Model model)
    {
        BannerUpdateDto bannerUpdateDto =bannerService.findUpdateBanner(id);
        model.addAttribute("banner", bannerUpdateDto);
        return "/dashboard/banner/update";
    }
    @PostMapping("/admin/banner/update")
    public String updateBanner(@ModelAttribute BannerUpdateDto bannerUpdateDto)
    {
        bannerService.updateBanner(bannerUpdateDto);
        return "redirect:/admin/banner";
    }

}
