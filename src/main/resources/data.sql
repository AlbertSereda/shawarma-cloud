delete from Ingredient_Ref;
delete from Shawarma;
delete from Shawarma_Order;
delete from Ingredient;

insert into Ingredient (id, name, type)
values ('CLLA', 'Classic lavash', 'WRAP');

insert into Ingredient (id, name, type)
values ('GALA', 'Garlic lavash', 'WRAP');

insert into Ingredient (id, name, type)
values ('CHLA', 'Cheese lavash', 'WRAP');

insert into Ingredient (id, name, type)
values ('PITA', 'Pita', 'WRAP');

insert into Ingredient (id, name, type)
values ('CHIC', 'Chicken', 'MEAT');

insert into Ingredient (id, name, type)
values ('PORK', 'Pork', 'MEAT');

insert into Ingredient (id, name, type)
values ('TOMA', 'Tomatoes', 'VEGGIES');

insert into Ingredient (id, name, type)
values ('CUCU', 'Cucumbers', 'VEGGIES');

insert into Ingredient (id, name, type)
values ('CLSA', 'Classic sauce', 'SAUCE');

insert into Ingredient (id, name, type)
values ('CHSA', 'Cheese sauce', 'SAUCE');

insert into Ingredient (id, name, type)
values ('SPSA', 'Spacy sauce', 'SAUCE');

insert into Ingredient (id, name, type)
values ('CHAD', 'Cheese', 'ADDITIVES');

insert into Ingredient (id, name, type)
values ('JAAD', 'Jalapeno', 'ADDITIVES');