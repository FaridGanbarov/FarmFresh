package finalproject.az.farmfresh.controller;

import finalproject.az.farmfresh.dtos.productdtos.ProductDetailDto;
import finalproject.az.farmfresh.dtos.productdtos.ProductHomeDto;
import finalproject.az.farmfresh.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductService productService;
    @GetMapping("/productDetail/{id}")
    public String index(@PathVariable Long id, Model model)
    {
        ProductDetailDto productDetail=productService.productDetail(id);
        model.addAttribute("product", productDetail);
        List<ProductHomeDto> homeProducts =productService.getHomeProducts();
        model.addAttribute("products", homeProducts);
        return "productDetail";
    }
}
