package com.br.exemplo.crud.dtos;

import com.br.exemplo.crud.entities.Categoria;

public record CategoriaConsultaDTO(Long id, String nome) {
    public static CategoriaConsultaDTO create(Categoria categoria) {
        return new CategoriaConsultaDTO(categoria.getId(), categoria.getNome());
    }

    public Categoria toEntity(){
        return new Categoria(id, nome);
    }
}
