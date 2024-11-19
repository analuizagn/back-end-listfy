package projeto.listify.service.impl;

import org.springframework.stereotype.Service;
import projeto.listify.entity.Categoria;
import projeto.listify.exception.BusinessException;
import projeto.listify.repository.CategoriaRepository;
import projeto.listify.service.ICategoriaService;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

        public Categoria createCategoria(Categoria categoria) {
            return categoriaRepository.save(categoria);
        }

        public List<Categoria> findAllCategorias() {
            return categoriaRepository.findAll();
        }

        public Categoria findCategoriaById(Long id) {
            return categoriaRepository.findById(id)
                    .orElseThrow(() -> new BusinessException("Categoria com ID " + id + " não encontrada."));
        }

        public Categoria updateCategoria(Long id, Categoria categoria) {
            Categoria existingCategoria = findCategoriaById(id);
            existingCategoria.setNome(categoria.getNome());
            return categoriaRepository.save(existingCategoria);
        }

        public void deleteCategoria(Long id) {
            Categoria existingCategoria = findCategoriaById(id);
            categoriaRepository.delete(existingCategoria);
        }

}
