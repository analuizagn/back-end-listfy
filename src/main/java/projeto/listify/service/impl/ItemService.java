package projeto.listify.service.impl;

import org.springframework.stereotype.Service;
import projeto.listify.entity.Item;
import projeto.listify.exception.BusinessException;
import projeto.listify.repository.ItemRepository;
import projeto.listify.repository.ListaRepository;
import projeto.listify.service.IItemService;

import java.util.List;

@Service
public class ItemService implements IItemService {
    private final ItemRepository itemRepository;
    private final ListaRepository listaRepository;

    public ItemService(ItemRepository itemRepository, ListaRepository listaRepository) {
        this.itemRepository = itemRepository;
        this.listaRepository = listaRepository;
    }

    public Item createItem(Item item) {
        // Verifica se a lista existe antes de adicionar o item
        listaRepository.findById(item.getLista().getId())
                .orElseThrow(() -> new BusinessException("Lista não encontrada."));
        return itemRepository.save(item);
    }

    public List<Item> findAllItemsByListaId(Long listaId) {
        return itemRepository.findAll().stream()
                .filter(item -> item.getLista().getId().equals(listaId))
                .toList();
    }

    public Item findItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Item com ID " + id + " não encontrado."));
    }

    public void deleteItem(Long id) {
        Item existingItem = findItemById(id);
        itemRepository.delete(existingItem);
    }

}
