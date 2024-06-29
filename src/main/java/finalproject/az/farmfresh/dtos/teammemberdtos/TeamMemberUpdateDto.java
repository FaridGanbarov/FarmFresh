package finalproject.az.farmfresh.dtos.teammemberdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMemberUpdateDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Designation must contain only letters, spaces, hyphens, or apostrophes")
    private String name;

    @NotBlank(message = "Designation is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Designation must contain only letters, spaces, hyphens, or apostrophes")
    private String designation;

    @NotNull(message = "Photo is mandatory")
    private String photoUrl;
}
