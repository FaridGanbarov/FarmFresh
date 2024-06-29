package finalproject.az.farmfresh.repositories;

import finalproject.az.farmfresh.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {
}
