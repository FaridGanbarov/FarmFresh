package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryCreateProductDto;
import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryProductDto;

import java.util.List;

public interface CategoryProductService {
    void add(CategoryCreateProductDto categoryProductCreateDto);
    List<CategoryProductDto> getAllProductCategories();
}
