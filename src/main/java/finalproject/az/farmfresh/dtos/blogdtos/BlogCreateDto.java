package finalproject.az.farmfresh.dtos.blogdtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCreateDto {
    private String title;
    private String subTitle;
    private String description;
    private String photoUrl;
    private Long categoryBlogId;
}
