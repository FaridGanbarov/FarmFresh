package finalproject.az.farmfresh.repositories;

import finalproject.az.farmfresh.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
