package finalproject.az.farmfresh.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "team_members")
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+([ '-][a-zA-Z]+)*$", message = "Name must contain only letters, spaces, hyphens, or apostrophes")
    private String name;
    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotNull(message = "Photo is mandatory")
    @Column(name ="photoUrl", length = 10000)
    private String photoUrl;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;
}
