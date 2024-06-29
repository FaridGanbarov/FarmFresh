package finalproject.az.farmfresh.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "testimonials")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+([ '-][a-zA-Z]+)*$", message = "Name must contain only letters, spaces, hyphens, or apostrophes")
    private String name;

    @NotBlank(message = "Thought is mandatory")
    @Column(name ="thought", length = 10000)
    private String thought;

    @NotNull(message = "Photo is mandatory")
    @Column(name ="photoUrl", length = 10000)
    private String photoUrl;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;

}
