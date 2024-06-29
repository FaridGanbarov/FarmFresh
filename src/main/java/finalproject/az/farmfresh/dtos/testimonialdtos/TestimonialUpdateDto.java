package finalproject.az.farmfresh.dtos.testimonialdtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialUpdateDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+([ '-][a-zA-Z]+)*$", message = "Name must contain only letters, spaces, hyphens, or apostrophes")
    private String name;

    @NotBlank(message = "Thought is mandatory")
    private String thought;

    @NotNull(message = "Photo is mandatory")
    private String photoUrl;
}
