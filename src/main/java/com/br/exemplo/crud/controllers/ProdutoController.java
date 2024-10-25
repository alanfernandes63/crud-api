package com.br.exemplo.crud.controllers;

import com.br.exemplo.crud.dtos.ProdutoAtualizaDTO;
import com.br.exemplo.crud.dtos.ProdutoConsultaDTO;
import com.br.exemplo.crud.dtos.ProdutoSalvaDTO;
import com.br.exemplo.crud.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

    private ProdutoService service;

    @GetMapping
    public List<ProdutoConsultaDTO> findAll() {
        return this.service.findAll()
                .stream()
                .map(ProdutoConsultaDTO::create)
                .toList();
    }

    @GetMapping("/{id}")
    public ProdutoConsultaDTO findById(@PathVariable Long id) {
        return ProdutoConsultaDTO
                .create(this.service.findById(id));
    }

    @PostMapping
    public ProdutoConsultaDTO save(@RequestBody @Valid ProdutoSalvaDTO produtoSalvaDTO) {
        return ProdutoConsultaDTO
                .create(this.service.save(produtoSalvaDTO));
    }

    @PutMapping("/{id}")
    public ProdutoConsultaDTO update(@PathVariable Long id, @RequestBody ProdutoAtualizaDTO produtoAtualizaDTO) {
        return ProdutoConsultaDTO
                .create(this.service.update(id, produtoAtualizaDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
