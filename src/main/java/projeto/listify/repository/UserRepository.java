package projeto.listify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.listify.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}