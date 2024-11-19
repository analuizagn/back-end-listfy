package projeto.listify.service;

import projeto.listify.entity.Lista;

import java.util.List;

public interface IListaService {
    Lista createLista(Lista lista);
    List<Lista> findAllListas();
    Lista findListaById(Long id);
    Lista updateLista(Long id, Lista lista);
    void deleteLista(Long id);
}
