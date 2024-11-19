package projeto.listify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.listify.dto.response.ListaView;
import projeto.listify.entity.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {
    void delete(ListaView existingLista);
}