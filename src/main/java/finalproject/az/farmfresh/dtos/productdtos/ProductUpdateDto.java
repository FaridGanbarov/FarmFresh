package finalproject.az.farmfresh.dtos.productdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {
    private Long id;
    private String name;
    private Long price;
    private String description;
    private String photoUrl;
    private Long categoryProductId;
}
