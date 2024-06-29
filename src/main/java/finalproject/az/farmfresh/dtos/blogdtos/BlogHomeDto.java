package finalproject.az.farmfresh.dtos.blogdtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BlogHomeDto {
    private Long id;
    private String title;
    private String subTitle;
    private Date createdDate;
    private String photoUrl;

}
