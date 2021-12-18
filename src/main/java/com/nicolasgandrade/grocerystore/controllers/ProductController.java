package com.nicolasgandrade.grocerystore.controllers;

import com.nicolasgandrade.grocerystore.domain.Product;
import com.nicolasgandrade.grocerystore.dto.ProductDTO;
import com.nicolasgandrade.grocerystore.dto.SectionDTO;
import com.nicolasgandrade.grocerystore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO dto) {
        Product product = service.insert(dto.dtoToProduct());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
