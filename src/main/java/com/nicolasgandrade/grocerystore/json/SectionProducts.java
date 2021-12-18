package com.nicolasgandrade.grocerystore.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nicolasgandrade.grocerystore.domain.Product;
import com.nicolasgandrade.grocerystore.domain.Section;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SectionProducts {

    private Integer id;
    private String name;
    @JsonIgnoreProperties("section")
    private List<Product> products = new ArrayList<>();

    public SectionProducts() {
    }

    public SectionProducts(Section section) {
        this.id = section.getId();
        this.name = section.getName();
        this.products = section.getProducts();
    }
}
