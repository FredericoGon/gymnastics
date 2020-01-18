package com.gymnastics.gymnastics.atletas;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atletas")
public class AtletasController {

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping
    public List<Atleta> list() {
        return atletaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Atleta get(@PathVariable Long id) {
        return atletaRepository.getOne(id);
    }

    @PostMapping
    public Atleta create(@RequestBody final Atleta atleta) {
        return atletaRepository.saveAndFlush(atleta);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        atletaRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Atleta update(@PathVariable Long id, @RequestBody Atleta atleta) {
        Atleta existingAtleta = atletaRepository.getOne(id);
        BeanUtils.copyProperties(atleta, existingAtleta, "atleta_id");
        return atletaRepository.saveAndFlush(existingAtleta);
    }

}
