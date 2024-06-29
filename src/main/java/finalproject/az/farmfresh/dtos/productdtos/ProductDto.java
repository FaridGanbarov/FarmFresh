package finalproject.az.farmfresh.dtos.productdtos;

import finalproject.az.farmfresh.dtos.categoryproductdtos.CategoryProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String photoUrl;
    private int viewCount;
    private Date createdDate;
    private Date updatedDate;
    private Long price;
    private CategoryProductDto categoryProduct;
}
