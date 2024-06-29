package finalproject.az.farmfresh.dtos.aboutusdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AboutUsCreateDto {
    private String title;
    private String subTitle;
    private String photoUrl;
    private String organic;
    private String winning;
}
