package projeto.listify.dto.response;

import projeto.listify.entity.Item;
import projeto.listify.entity.Lista;

import java.util.List;

public class ListaView {

    private Long id;
    private String nome;
    private List<Item> itens;

    public ListaView(Long id, String nome, List<Item> itens) {
        this.id = id;
        this.nome = nome;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public ListaView(Lista lista) {
        this.id = lista.getId();
        this.nome = lista.getNome();
        this.itens = lista.getItens();
    }
}
