package projeto.listify.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private boolean concluido;

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Item(Long id, String nome, boolean b, Lista lista, Categoria categoria) {
    }

    public Item() {
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

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isConcluido() {
        return true;
    }
}
