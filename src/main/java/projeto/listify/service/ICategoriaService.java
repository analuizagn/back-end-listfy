package projeto.listify.service;

import projeto.listify.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    Categoria createCategoria(Categoria categoria);
    List<Categoria> findAllCategorias();
    Categoria findCategoriaById(Long id);
    Categoria updateCategoria(Long id, Categoria categoria);
    void deleteCategoria(Long id);
}
