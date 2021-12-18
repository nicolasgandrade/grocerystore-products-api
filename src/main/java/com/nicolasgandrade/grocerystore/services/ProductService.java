package com.nicolasgandrade.grocerystore.services;

import com.nicolasgandrade.grocerystore.domain.Product;
import com.nicolasgandrade.grocerystore.dto.ProductDTO;
import com.nicolasgandrade.grocerystore.repositories.ProductRepository;
import com.nicolasgandrade.grocerystore.services.exceptions.DatabaseException;
import com.nicolasgandrade.grocerystore.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Object not found"));
    }

    public Product insert(Product obj) {
        return productRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Object not found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public void updateData(Product original, ProductDTO obj) {
        original.setName(obj.getName());
        original.setPrice(obj.getPrice());
        original.setStock(obj.getStock());
        original.setSection(obj.getSection());
    }

    public Product update(Integer id, ProductDTO obj) {
        try {
            Product product = productRepository.getById(id);
            updateData(product, obj);
            return productRepository.save(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Object not found");
        }
    }
}
