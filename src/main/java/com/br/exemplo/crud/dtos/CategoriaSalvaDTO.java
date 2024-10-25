package com.br.exemplo.crud.dtos;

import com.br.exemplo.crud.entities.Categoria;
import jakarta.validation.constraints.NotBlank;

public record CategoriaSalvaDTO(@NotBlank(message = "O nome é obrigatório") String nome) {
    public Categoria toEntity(){
        return new Categoria(nome);
    }
}
