package finalproject.az.farmfresh.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @Column(name ="description", length = 10000)
    private String description;

    @Column(name ="photoUrl", length = 10000)
    private String photoUrl;

    private Long price;
    private Date createdDate;
    private Date updatedDate;

    private int viewCount;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;

    @ManyToOne
    private CategoryProduct categoryProduct;



}
