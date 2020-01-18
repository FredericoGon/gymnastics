package com.gymnastics.gymnastics.competicoes;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competicoes")
public class CompeticaoController {

    @Autowired
    private CompeticaoRepository competicaoRepository;

    @GetMapping
    public List<Competicao> list() {
        return competicaoRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Competicao get(@PathVariable Long id) {
        return competicaoRepository.getOne(id);
    }

    @PostMapping
    public Competicao create(@RequestBody final Competicao competicao) {
        return competicaoRepository.saveAndFlush(competicao);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        competicaoRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Competicao update(@PathVariable Long id, @RequestBody Competicao competicao) {
        Competicao existingCompeticao = competicaoRepository.getOne(id);
        BeanUtils.copyProperties(competicao, existingCompeticao, "competicaoId");
        return competicaoRepository.saveAndFlush(existingCompeticao);
    }
}
