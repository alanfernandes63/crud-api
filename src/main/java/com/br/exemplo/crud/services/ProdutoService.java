package com.br.exemplo.crud.services;

import com.br.exemplo.crud.dtos.ProdutoAtualizaDTO;
import com.br.exemplo.crud.dtos.ProdutoSalvaDTO;
import com.br.exemplo.crud.entities.Produto;
import com.br.exemplo.crud.exceptions.NegocioException;
import com.br.exemplo.crud.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

    private ProdutoRepository repository;

    private CategoriaService categoriaService;

    public List<Produto> findAll() {
        return this.repository.findAll();
    }

    public Produto findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NegocioException("Produto não encontrado!"));
    }

    @Transactional
    public Produto save(ProdutoSalvaDTO produtoSalvaDTO) {
         var categoria = this.categoriaService.findById(produtoSalvaDTO.idCategoria());
        return this.repository.save(produtoSalvaDTO.toEntity(categoria));
    }

    @Transactional
    public Produto update(Long id, ProdutoAtualizaDTO produtoAtualizaDTO) {
        this.findById(id);
        var categoria = this.categoriaService.findById(produtoAtualizaDTO.idCategoria());
        return this.repository.save(produtoAtualizaDTO.toEntity(id, categoria));
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
