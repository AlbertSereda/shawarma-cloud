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

    /*public IngredientByIdConverter() {
        ingredientMap.put("CLLA",  new Ingredient("CLLA", "Classic lavash", Ingredient.Type.WRAP));
        ingredientMap.put("GALA",  new Ingredient("GALA", "Garlic lavash", Ingredient.Type.WRAP));
        ingredientMap.put("CHLA",  new Ingredient("CHLA", "Cheese lavash", Ingredient.Type.WRAP));
        ingredientMap.put("PITA",  new Ingredient("PITA", "Pita", Ingredient.Type.WRAP));
        ingredientMap.put("CHIC",  new Ingredient("CHIC", "Chicken", Ingredient.Type.MEAT));
        ingredientMap.put("PORK",  new Ingredient("PORK", "Pork", Ingredient.Type.MEAT));
        ingredientMap.put("TOMA",  new Ingredient("TOMA", "Tomatoes", Ingredient.Type.VEGGIES));
        ingredientMap.put("CUCU",  new Ingredient("CUCU", "Cucumbers", Ingredient.Type.VEGGIES));
        ingredientMap.put("CLSA",  new Ingredient("CLSA", "Classic sauce", Ingredient.Type.SAUCE));
        ingredientMap.put("CHSA",  new Ingredient("CHSA", "Cheese sauce", Ingredient.Type.SAUCE));
        ingredientMap.put("SPSA",  new Ingredient("SPSA", "Spacy sauce", Ingredient.Type.SAUCE));
        ingredientMap.put("CHAD",  new Ingredient("CHAD", "Cheese", Ingredient.Type.ADDITIVES));
        ingredientMap.put("JAAD",  new Ingredient("JAAD", "Jalapeno", Ingredient.Type.ADDITIVES));
    }*/

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
