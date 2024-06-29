package finalproject.az.farmfresh.services.impl;


import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryCreateProductDto;
import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryProductDto;
import finalproject.az.farmfresh.models.CategoryProduct;
import finalproject.az.farmfresh.repositories.CategoryProductRepository;
import finalproject.az.farmfresh.services.CategoryProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
    @Autowired
    private CategoryProductRepository categoryProductRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void add(CategoryCreateProductDto categoryCreateProductDto) {
        CategoryProduct categoryProduct = modelMapper.map(categoryCreateProductDto, CategoryProduct.class);
        categoryProductRepository.save(categoryProduct);
    }

    @Override
    public List<CategoryProductDto> getAllProductCategories() {
        List<CategoryProductDto> productCategories = categoryProductRepository.findAll().stream()
                .map(categoryProduct -> modelMapper.map(categoryProduct, CategoryProductDto.class))
                .collect(Collectors.toList());
        return productCategories;
    }
}


