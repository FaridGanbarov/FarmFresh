package finalproject.az.farmfresh.dtos.blogdtos;

import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BlogDetailDto {
    private Long id;
    private String title;
    private String subTitle;
    private String description;
    private String photoUrl;
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    private CategoryBlogDto categoryBlog;
}
