package com.br.exemplo.crud.controllers;

import com.br.exemplo.crud.dtos.CategoriaAtualizaDTO;
import com.br.exemplo.crud.dtos.CategoriaConsultaDTO;
import com.br.exemplo.crud.dtos.CategoriaSalvaDTO;
import com.br.exemplo.crud.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaController {

    private CategoriaService service;

    @GetMapping
    public List<CategoriaConsultaDTO> findAll() {
        return this.service.findAll()
                .stream()
                .map(CategoriaConsultaDTO::create)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoriaConsultaDTO findById(@PathVariable Long id) {
        return CategoriaConsultaDTO
                .create(this.service.findById(id));
    }

    @PostMapping
    public CategoriaConsultaDTO save(@RequestBody CategoriaSalvaDTO categoriaSaveDTO) {
        return CategoriaConsultaDTO
                .create(this.service.save(categoriaSaveDTO));
    }

    @PutMapping("/{id}")
    public CategoriaConsultaDTO update(@PathVariable Long id, @RequestBody CategoriaAtualizaDTO categoriaAtualizaDTO) {
        return CategoriaConsultaDTO
                .create(this.service.update(id, categoriaAtualizaDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
