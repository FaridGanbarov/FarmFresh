package finalproject.az.farmfresh.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "facts")
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number;
    private String iconClass;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;


}
