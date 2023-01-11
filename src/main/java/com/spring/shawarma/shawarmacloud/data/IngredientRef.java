package com.spring.shawarma.shawarmacloud.data;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Ingredient_Ref")
public class IngredientRef {

    @Column("ingredient")
    private final String ingredient;

    public IngredientRef(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }
}
