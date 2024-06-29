package finalproject.az.farmfresh.repositories;

import finalproject.az.farmfresh.models.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepository extends JpaRepository<Fact, Long> {
}
