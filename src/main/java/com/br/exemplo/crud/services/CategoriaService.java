package com.br.exemplo.crud.services;

import com.br.exemplo.crud.dtos.CategoriaAtualizaDTO;
import com.br.exemplo.crud.dtos.CategoriaSalvaDTO;
import com.br.exemplo.crud.entities.Categoria;
import com.br.exemplo.crud.exceptions.NegocioException;
import com.br.exemplo.crud.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return this.repository.findAll();
    }

    public Categoria findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NegocioException("Categoria não encontrada"));
    }

    @Transactional
    public Categoria save(CategoriaSalvaDTO categoriaSaveDTO) {
        return this.repository.save(categoriaSaveDTO.toEntity());
    }

    @Transactional
    public Categoria update(Long id, CategoriaAtualizaDTO categoriaAtualizaDTO) {
        this.findById(id);
        var categoria = categoriaAtualizaDTO.toEntity();
        categoria.setId(id);
        return this.repository.save(categoria);
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
