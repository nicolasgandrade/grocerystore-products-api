package com.nicolasgandrade.grocerystore.controllers;

import com.nicolasgandrade.grocerystore.domain.Section;
import com.nicolasgandrade.grocerystore.dto.SectionDTO;
import com.nicolasgandrade.grocerystore.json.SectionProducts;
import com.nicolasgandrade.grocerystore.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sections")
public class SectionController {

    @Autowired
    private SectionService service;

    @GetMapping
    public ResponseEntity<List<Section>> findAll() {
        List<Section> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SectionProducts> findById(@PathVariable Integer id) {
        Section sec = service.findById(id);
        SectionProducts obj = new SectionProducts(sec);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Section> insert(@RequestBody SectionDTO dto) {
        Section section = service.insert(dto.dtoToSection());
        return new ResponseEntity<>(section, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SectionDTO> update(@PathVariable Integer id, @RequestBody SectionDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
