package projeto.listify.dto.request;

import jakarta.validation.constraints.NotEmpty;
import projeto.listify.entity.Categoria;

public class CategoriaDto {

    @NotEmpty(message = "Nome não pode estar vazio")
    private String nome;

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toEntity() {
        return new Categoria(
                null,
                this.nome);
    }
}
