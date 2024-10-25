package com.br.exemplo.crud.repositories;

import com.br.exemplo.crud.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
