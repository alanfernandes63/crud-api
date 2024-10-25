package com.br.exemplo.crud.dtos;

import com.br.exemplo.crud.entities.Categoria;
import com.br.exemplo.crud.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoSalvaDTO(@NotBlank(message = "O nome é obrigatório") String nome,
                              @NotNull(message = "O preço é obrigatório") BigDecimal preco,
                              @NotNull(message = "A categoria é obrigatória") Long idCategoria) {
    public Produto toEntity(Categoria categoria) {
        return new Produto(nome, preco, categoria);
    }
}
