package com.br.exemplo.crud.repositories;

import com.br.exemplo.crud.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
