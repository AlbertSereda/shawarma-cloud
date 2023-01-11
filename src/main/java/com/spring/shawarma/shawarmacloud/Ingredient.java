package com.spring.shawarma.shawarmacloud;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("Ingredient")
public class Ingredient {

    @Id
    @Column("id")
    private final String id;

    @Column("name")
    private final String name;

    @Column("type")
    private final Type type;

    public enum Type {
        WRAP, MEAT, VEGGIES, SAUCE, ADDITIVES
    }

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id.equals(that.id) && name.equals(that.name) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
