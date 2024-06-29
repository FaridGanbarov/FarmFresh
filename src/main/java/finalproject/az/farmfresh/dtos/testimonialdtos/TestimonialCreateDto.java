package finalproject.az.farmfresh.dtos.testimonialdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialCreateDto {
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)*$", message = "First name must contain only letters and single spaces between words")
    private String name;

    @NotNull(message = "Photo is mandatory")
    private String photoUrl;


    @NotBlank(message = "Thought is mandatory")
    private String thought;
}
