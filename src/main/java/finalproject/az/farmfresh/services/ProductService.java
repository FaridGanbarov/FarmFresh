package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.productdtos.*;
import finalproject.az.farmfresh.models.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts();
    void addProduct(ProductCreateDto productDto);
    List<ProductHomeDto> getHomeProducts();
    void updateProduct(ProductUpdateDto productDto);
    ProductUpdateDto findUpdateProduct(Long id);
    ProductDetailDto productDetail(Long id);
    void removeProduct(Long productId);

}

