package finalproject.az.farmfresh.dtos.aboutusdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AboutUsUpdateDto {
    private Long id;
    private String title;
    private String subTitle;
    private String photoUrl;
    private String organic;
    private String winning;
}
