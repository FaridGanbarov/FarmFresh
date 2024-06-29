package finalproject.az.farmfresh.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "organic_farm_services")
public class OrganicFarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private String iconClass;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;
}
