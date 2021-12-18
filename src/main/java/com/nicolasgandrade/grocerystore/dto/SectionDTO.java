package com.nicolasgandrade.grocerystore.dto;

import com.nicolasgandrade.grocerystore.domain.Product;
import com.nicolasgandrade.grocerystore.domain.Section;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class SectionDTO implements Serializable {

    private String name;
    
    public SectionDTO(Section section) {
        this.name = section.getName();
    }

    public Section dtoToSection() {
        return new Section(null, name);
    }

}
