package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.blogdtos.*;
import finalproject.az.farmfresh.models.Blog;

import java.util.List;

public interface BlogService {
    List<BlogDto> getBlogs();
    void addBlog(BlogCreateDto blogDto);
    List<BlogHomeDto> getHomeBlogs();
    void updateBlog(BlogUpdateDto blogDto);
    BlogUpdateDto findUpdateBlog(Long id);
    BlogDetailDto blogDetail(Long id);
    void removeBlog(Long blogId);
}
