package com.nicolasgandrade.grocerystore.repositories;

import com.nicolasgandrade.grocerystore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
