CREATE TABLE itens (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome VARCHAR(255) NOT NULL,
    lista_id BIGINT NOT NULL,
    categoria_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (lista_id) REFERENCES listas(id) ON DELETE CASCADE,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE CASCADE
);