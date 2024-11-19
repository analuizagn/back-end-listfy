package projeto.listify.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import projeto.listify.entity.Categoria;
import projeto.listify.entity.Item;
import projeto.listify.entity.Lista;

public class ItemDto {

    @NotEmpty(message = "Nome vazio")
    private String nome;
    @NotNull(message = "Lista não pode ser nula")
    private Long listaId;
    private Long categoriaId;

    public ItemDto(String nome, Long listaId, Long categoriaId) {
        this.nome = nome;
        this.listaId = listaId;
        this.categoriaId = categoriaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getListaId() {
        return listaId;
    }
    public void setListaId(Long listaId) {
        this.listaId = listaId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Item toEntity(Lista lista, Categoria categoria) {
        return new Item(
                null,
                nome,
                lista,
                categoria);
    }

}
