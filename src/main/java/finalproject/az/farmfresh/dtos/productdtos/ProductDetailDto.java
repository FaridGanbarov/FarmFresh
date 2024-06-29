package finalproject.az.farmfresh.dtos.productdtos;

import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDetailDto {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private String photoUrl;
    private Date createdDate;
    private Date updatedDate;
    private int viewCount;
    private CategoryProductDto categoryProduct;
}
