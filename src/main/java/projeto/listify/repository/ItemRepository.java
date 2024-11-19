package projeto.listify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.listify.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}