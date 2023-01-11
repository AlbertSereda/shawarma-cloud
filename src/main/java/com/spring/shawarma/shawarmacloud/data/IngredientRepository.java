package com.spring.shawarma.shawarmacloud.data;

import com.spring.shawarma.shawarmacloud.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
