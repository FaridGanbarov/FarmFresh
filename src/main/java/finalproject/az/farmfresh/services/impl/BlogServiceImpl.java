package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.blogdtos.*;
import finalproject.az.farmfresh.models.Blog;
import finalproject.az.farmfresh.models.CategoryBlog;
import finalproject.az.farmfresh.repositories.BlogRepository;
import finalproject.az.farmfresh.repositories.CategoryBlogRepository;
import finalproject.az.farmfresh.services.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryBlogRepository categoryBlogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BlogDto> getBlogs() {
        List<BlogDto> blogDtoList=blogRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(blog->modelMapper.map(blog, BlogDto.class))
                .collect(Collectors.toList());
        return blogDtoList;
    }

    @Override
    public void addBlog(BlogCreateDto blogDto) {
        try{
            Blog blog = new Blog();
            blog.setUpdatedDate(new Date());
            blog.setCreatedDate(new Date());
            blog.setTitle(blogDto.getTitle());
            blog.setPhotoUrl(blogDto.getPhotoUrl());

            blog.setIsDeleted(false);
            blog.setDescription(blogDto.getDescription());
            blog.setSubTitle(blogDto.getSubTitle());
            CategoryBlog categoryBlog = categoryBlogRepository.findById(blogDto.getCategoryBlogId()).get();
            blog.setCategoryBlog(categoryBlog);
            blogRepository.save(blog);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<BlogHomeDto> getHomeBlogs() {
        List<BlogHomeDto> blogDtoList = blogRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(blog -> modelMapper.map(blog, BlogHomeDto.class))
                .collect(Collectors.toList());
        return blogDtoList;
    }

    @Override
    public void updateBlog(BlogUpdateDto blogDto) {
        Blog findBlog = blogRepository.findById(blogDto.getId()).orElseThrow();
        CategoryBlog categoryBLog = categoryBlogRepository.findById(blogDto.getCategoryBlogId()).orElseThrow();
        findBlog.setId(blogDto.getId());
        findBlog.setTitle(blogDto.getTitle());
        findBlog.setDescription(blogDto.getDescription());
        findBlog.setUpdatedDate(new Date());
        findBlog.setPhotoUrl(blogDto.getPhotoUrl());
        findBlog.setSubTitle(blogDto.getSubTitle());
        findBlog.setCategoryBlog(categoryBLog);
        blogRepository.saveAndFlush(findBlog);
    }

    @Override
    public BlogUpdateDto findUpdateBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow();
        BlogUpdateDto blogUpdateDto = modelMapper.map(blog, BlogUpdateDto.class);
        return blogUpdateDto;
    }

    @Override
    public BlogDetailDto blogDetail(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow();
        BlogDetailDto blogUpdateDto = modelMapper.map(blog,BlogDetailDto.class);
        return blogUpdateDto;
    }

    @Override
    public void removeBlog(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow();
        blog.setIsDeleted(true);
        blogRepository.save(blog);
    }

}
