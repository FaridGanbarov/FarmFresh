package finalproject.az.farmfresh.dtos.blogdtos;


import finalproject.az.farmfresh.dtos.categoryblogdtos.CategoryBlogDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BlogDto {
    private Long id;
    private String title;

    private String photoUrl;
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    private CategoryBlogDto categoryBlog;
}
