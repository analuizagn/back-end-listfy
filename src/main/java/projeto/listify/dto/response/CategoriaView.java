package projeto.listify.dto.response;

import projeto.listify.entity.Categoria;

public class CategoriaView {

    private Long id;
    private String nome;

    public CategoriaView(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public CategoriaView(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}

