package finalproject.az.farmfresh.models;


import groovy.transform.Sealed;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="categoriesblogs")
public class CategoryBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "blogs", nullable = true)
    private List<Blog> blogs;
}
