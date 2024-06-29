package finalproject.az.farmfresh.repositories;

import finalproject.az.farmfresh.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
