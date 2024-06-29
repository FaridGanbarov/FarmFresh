package finalproject.az.farmfresh.repositories;

import finalproject.az.farmfresh.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
