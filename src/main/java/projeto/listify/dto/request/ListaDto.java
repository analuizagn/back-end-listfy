package projeto.listify.dto.request;

import jakarta.validation.constraints.NotEmpty;
import projeto.listify.entity.Item;
import projeto.listify.entity.Lista;

import java.util.List;

public class ListaDto {

    @NotEmpty(message = "Nome não pode estar vazio")
    private String nome;
    private List<Item> itens;

    public ListaDto(String nome, List<Item> itens) {
        this.nome = nome;
        this.itens = itens;
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

    public Lista toEntity() {
        return new Lista(
                null,
                this.nome,
                this.itens);
    }

}
