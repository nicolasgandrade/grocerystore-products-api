package com.nicolasgandrade.grocerystore.dto;

import com.nicolasgandrade.grocerystore.domain.Product;
import com.nicolasgandrade.grocerystore.domain.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private Double price;
    private Integer stock;
    private Section section;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.section = product.getSection();
    }

    public Product dtoToProduct() {
        return new Product(null, name, price, stock, section);
    }

}
