package com.gymnastics.gymnastics.competicoes;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipes")
public class EquipesController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public List<Equipe> list() {
        return equipeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Equipe get(@PathVariable Long id) {
        return equipeRepository.getOne(id);
    }

    @PostMapping
    public Equipe create(@RequestBody final Equipe equipe) {
        return equipeRepository.saveAndFlush(equipe);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        equipeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Equipe update(@PathVariable Long id, @RequestBody Equipe equipe) {
        Equipe existingEquipe = equipeRepository.getOne(id);
        BeanUtils.copyProperties(equipe, existingEquipe, "equipeId");
        return equipeRepository.saveAndFlush(existingEquipe);
    }
}
