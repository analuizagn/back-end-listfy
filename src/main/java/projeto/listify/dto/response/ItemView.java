package projeto.listify.dto.response;

import projeto.listify.entity.Item;

public class ItemView {

    private String nome;
    private boolean concluido;
    private Long listaId;
    private Long categoriaId;

    public ItemView(Item item) {
        this.nome = item.getNome();
        this.concluido = item.isConcluido();
        this.listaId = item.getLista().getId();
        this.categoriaId = item.getCategoria() != null ? item.getCategoria().getId() : null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
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
}
