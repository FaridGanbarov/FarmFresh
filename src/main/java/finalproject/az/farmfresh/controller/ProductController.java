package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryProductDto;
import finalproject.az.farmfresh.dtos.featuredtos.FeatureHomeDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductHomeDto;
import finalproject.az.farmfresh.services.CategoryProductService;
import finalproject.az.farmfresh.services.FeatureService;
import finalproject.az.farmfresh.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryProductService categoryProductService;
    @Autowired
    private FeatureService featureService;
    @GetMapping("/product")
    public String index(Model model)
    {

        List<CategoryProductDto> categoryProducts=categoryProductService.getAllProductCategories();
        List<ProductHomeDto> products =productService.getHomeProducts();
        model.addAttribute("products", products);
        model.addAttribute("categoryProducts", categoryProducts);
        List<FeatureHomeDto> homeFeatures = featureService.getHomeFeatures();
        model.addAttribute("features", homeFeatures);
        return "product";
    }
}
