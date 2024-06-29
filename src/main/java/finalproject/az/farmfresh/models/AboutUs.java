package finalproject.az.farmfresh.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="about_us")
public class AboutUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name ="subTitle", length = 10000)
    private String subTitle;
    @Column(name ="photoUrl", length = 10000)
    private String photoUrl;
    private String organic;
    private String winning;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;
}
