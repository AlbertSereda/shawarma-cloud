package com.spring.shawarma.shawarmacloud.web;

import com.spring.shawarma.shawarmacloud.Ingredient;
import com.spring.shawarma.shawarmacloud.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    @Autowired
    private IngredientRepository ingredientRepo;

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
