package com.gymnastics.gymnastics.clubes;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clubes")
public class ClubesController {

    @Autowired
    private ClubeRepository clubeRepository;

    @GetMapping
    public List<Clube> list() {
        return clubeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Clube get(@PathVariable Long id) {
        return clubeRepository.getOne(id);
    }

    @PostMapping
    public Clube create(@RequestBody final Clube clube) {
        return clubeRepository.saveAndFlush(clube);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        clubeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Clube update(@PathVariable Long id, @RequestBody Clube clube) {
        Clube existingClube = clubeRepository.getOne(id);
        BeanUtils.copyProperties(clube, existingClube, "clube_id");
        return clubeRepository.saveAndFlush(existingClube);
    }
}
