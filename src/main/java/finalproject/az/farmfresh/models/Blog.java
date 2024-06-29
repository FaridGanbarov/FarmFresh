package finalproject.az.farmfresh.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    @Column(name ="description", length = 10000)
    private String description;
    @Column(name ="photoUrl", length = 10000)
    private String photoUrl;
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isDeleted;

    @ManyToOne
    private CategoryBlog categoryBlog;
}

