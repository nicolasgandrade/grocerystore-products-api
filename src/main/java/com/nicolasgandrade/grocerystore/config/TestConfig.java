package com.nicolasgandrade.grocerystore.config;

import com.nicolasgandrade.grocerystore.domain.Product;
import com.nicolasgandrade.grocerystore.domain.Section;
import com.nicolasgandrade.grocerystore.repositories.ProductRepository;
import com.nicolasgandrade.grocerystore.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public void run(String... args) throws Exception {

        //Instantiates new sections
        Section s1 = new Section(null, "BEBIDAS");
        Section s2 = new Section(null, "DOCES");
        Section s3 = new Section(null, "HIGIENE");


        //Instantiates new products
        Product p1 = new Product(null, "SUCO LARANJA DELVALE 1L", 6.50, 34, s1);
        Product p2 = new Product(null, "BARRA CHOCOLATE HERSHEY'S AO LEITE 200G", 4.99, 105, s2);
        Product p3 = new Product(null, "SHAMPOO DOVE ANTI-QUEDAS 370ML", 7.80, 72, s3);

        s1.getProducts().add(p1);
        s2.getProducts().add(p2);
        s3.getProducts().add(p3);

        sectionRepository.saveAll(Arrays.asList(s1, s2, s3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
