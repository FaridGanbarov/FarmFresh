package finalproject.az.farmfresh.dtos.productdtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductHomeDto {
    private Long id;
    private String name;
    private String photoUrl;
    private Long price;
    private Date createdDate;
}
