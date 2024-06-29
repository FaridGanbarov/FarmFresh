package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryCreateBlogDto;

import java.util.List;

public interface CategoryBlogService {
    void add(CategoryCreateBlogDto categoryBlogCreateDto);
    List<CategoryBlogDto> getAllBlogCategories();

}
