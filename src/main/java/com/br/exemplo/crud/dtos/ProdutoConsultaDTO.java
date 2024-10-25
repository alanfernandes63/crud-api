package com.br.exemplo.crud.dtos;

import com.br.exemplo.crud.entities.Produto;

import java.math.BigDecimal;

public record ProdutoConsultaDTO(Long id, String nome, BigDecimal preco, Long idCategoria) {
    public static ProdutoConsultaDTO create(Produto produto) {
        return new ProdutoConsultaDTO(produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getCategoria().getId());
    }
}
