package projeto.listify.service.impl;

import org.springframework.stereotype.Service;
import projeto.listify.entity.Lista;
import projeto.listify.exception.BusinessException;
import projeto.listify.repository.ListaRepository;
import projeto.listify.service.IListaService;

import java.util.List;

@Service
public class ListaService implements IListaService {
    private final ListaRepository listaRepository;

    public ListaService(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    @Override
    public Lista createLista(Lista lista) {
        return listaRepository.save(lista);
    }

    @Override
    public List<Lista> findAllListas() {
        return listaRepository.findAll();
    }

    @Override
    public Lista findListaById(Long id) {
        return listaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Lista com ID " + id + " não encontrada."));
    }

    @Override
    public Lista updateLista(Long id, Lista lista) {
        Lista existingLista = findListaById(id);
        existingLista.setNome(lista.getNome());
        return listaRepository.save(existingLista);
    }

    @Override
    public void deleteLista(Long id) {
        Lista existingLista = findListaById(id);
        listaRepository.delete(existingLista);
    }
}
