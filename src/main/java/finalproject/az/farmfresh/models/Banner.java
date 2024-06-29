package finalproject.az.farmfresh.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity
@Table(name = "banners")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name ="subTitle", length = 10000)
    private String subTitle;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;

}
