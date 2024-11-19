package projeto.listify.service;

import projeto.listify.entity.Item;

import java.util.List;

public interface IItemService {
    Item createItem(Item item);
    List<Item> findAllItemsByListaId(Long listaId);
    Item findItemById(Long id);
    void deleteItem(Long id);
}
