package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryCreateBlogDto;
import finalproject.az.farmfresh.models.CategoryBlog;
import finalproject.az.farmfresh.models.CategoryProduct;
import finalproject.az.farmfresh.repositories.CategoryBlogRepository;
import finalproject.az.farmfresh.services.CategoryBlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryBlogServiceImpl implements CategoryBlogService {
    @Autowired
    private CategoryBlogRepository categoryBlogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void add(CategoryCreateBlogDto categoryCreateBlogDto)
    {
        CategoryBlog categoryBlog = modelMapper.map(categoryCreateBlogDto, CategoryBlog.class);
        categoryBlogRepository.save(categoryBlog);
    }

    @Override
    public List<CategoryBlogDto> getAllBlogCategories() {
        List<CategoryBlogDto> blogCategories = categoryBlogRepository.findAll().stream()
                .map(categoryBlog -> modelMapper.map(categoryBlog, CategoryBlogDto.class))
                .collect(Collectors.toList());
        return blogCategories;
    }

}
