package finalproject.az.farmfresh.services.impl;


import finalproject.az.farmfresh.dtos.blogdtos.BlogDetailDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogUpdateDto;
import finalproject.az.farmfresh.dtos.productdtos.*;
import finalproject.az.farmfresh.models.Blog;
import finalproject.az.farmfresh.models.CategoryProduct;
import finalproject.az.farmfresh.models.Product;
import finalproject.az.farmfresh.repositories.CategoryProductRepository;
import finalproject.az.farmfresh.repositories.ProductRepository;
import finalproject.az.farmfresh.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryProductRepository categoryProductRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList=productRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .distinct()
                .map(product->modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public void addProduct(ProductCreateDto productDto) {
        try{
            Product product = new Product();
            product.setUpdatedDate(new Date());
            product.setCreatedDate(new Date());
            product.setName(productDto.getName());
            product.setPhotoUrl(productDto.getPhotoUrl());

            product.setIsDeleted(false);
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            CategoryProduct categoryProduct = categoryProductRepository.findById(productDto.getCategoryProductId()).get();
            product.setCategoryProduct(categoryProduct);
            productRepository.save(product);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ProductHomeDto> getHomeProducts() {
        List<ProductHomeDto> productDtoList = productRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .distinct()
                .map(product -> modelMapper.map(product, ProductHomeDto.class))
                .collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public void updateProduct(ProductUpdateDto productDto) {
        Product findProduct = productRepository.findById(productDto.getId()).orElseThrow();
        CategoryProduct categoryProduct = categoryProductRepository.findById(productDto.getCategoryProductId()).orElseThrow();
        findProduct.setId(productDto.getId());
        findProduct.setName(productDto.getName());
        findProduct.setDescription(productDto.getDescription());
        findProduct.setUpdatedDate(new Date());
        findProduct.setPhotoUrl(productDto.getPhotoUrl());
        findProduct.setPrice(productDto.getPrice());
        findProduct.setCategoryProduct(categoryProduct);
        productRepository.saveAndFlush(findProduct);
    }

    @Override
    public ProductUpdateDto findUpdateProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductUpdateDto productUpdateDto = modelMapper.map(product, ProductUpdateDto.class);
        return productUpdateDto;
    }

    @Override
    public ProductDetailDto productDetail(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductDetailDto productUpdateDto = modelMapper.map(product,ProductDetailDto.class);
        return productUpdateDto;
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setIsDeleted(true);
        productRepository.save(product);
    }
}
