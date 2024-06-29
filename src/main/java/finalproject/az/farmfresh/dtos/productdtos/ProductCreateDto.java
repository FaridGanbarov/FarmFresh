package finalproject.az.farmfresh.dtos.productdtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateDto {
    private String name;

    private String description;

    private String photoUrl;

    private Long price;
    private Long categoryProductId;
}
