package projeto.listify.dto.request;

import jakarta.validation.constraints.NotEmpty;
import projeto.listify.entity.Lista;

public class ListaUpdateDto {
    @NotEmpty(message = "Nome não pode estar vazio")
    private String nome;

    public ListaUpdateDto() {
    }

    public ListaUpdateDto(String name) {
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Lista toEntity(Lista lista) {
        lista.setNome(this.nome);
        return lista;
    }
}
