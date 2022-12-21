package com.spring.shawarma.shawarmacloud;

import java.util.List;
import java.util.Objects;

public class Shawarma {
    private String name;
    private List<Ingredient> ingredients;

    public Shawarma(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shawarma shawarma = (Shawarma) o;
        return name.equals(shawarma.name) && ingredients.equals(shawarma.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients);
    }

    @Override
    public String toString() {
        return "Shawarma{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}