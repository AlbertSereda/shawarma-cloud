package com.spring.shawarma.shawarmacloud.data;

import com.spring.shawarma.shawarmacloud.Ingredient;
import com.spring.shawarma.shawarmacloud.Shawarma;
import com.spring.shawarma.shawarmacloud.ShawarmaOrder;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public ShawarmaOrder save(ShawarmaOrder shawarmaOrder) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Shawarma_Order " +
                        "(delivery_name, delivery_street, delivery_city, " +
                        "delivery_state, delivery_zip, cc_number, " +
                        "cc_expiration, cc_cvv, placed_at) " +
                        "values (?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        shawarmaOrder.setPlacedAt(new Date());

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        shawarmaOrder.getDeliveryName(),
                        shawarmaOrder.getDeliveryStreet(),
                        shawarmaOrder.getDeliveryCity(),
                        shawarmaOrder.getDeliveryState(),
                        shawarmaOrder.getDeliveryZip(),
                        shawarmaOrder.getCcNumber(),
                        shawarmaOrder.getCcExpiration(),
                        shawarmaOrder.getCcCVV(),
                        shawarmaOrder.getPlacedAt()
                )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        shawarmaOrder.setId(orderId);

        List<Shawarma> shawarmas = shawarmaOrder.getShawarmas();

        for (int i = 0; i < shawarmas.size(); i++) {
            saveShawarma(orderId, i, shawarmas.get(i));
        }
        return shawarmaOrder;
    }

    private long saveShawarma(Long orderId, int orderKey, Shawarma shawarma) {
        shawarma.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Shawarma " +
                        "(name, created_at, shawarma_order, shawarma_order_key) " +
                        "values (?, ?, ?, ?)",
                Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        shawarma.getName(),
                        shawarma.getCreatedAt(),
                        orderId,
                        orderKey
                )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long shawarmaId = keyHolder.getKey().longValue();
        shawarma.setId(shawarmaId);

        List<IngredientRef> ingredientRefs = ingredientsToRefConverter(shawarma.getIngredients());

        saveIngredientRefs(shawarmaId, ingredientRefs);

        return shawarmaId;
    }

    private List<IngredientRef> ingredientsToRefConverter(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(ing -> new IngredientRef(ing.getName()))
                .collect(Collectors.toList());
    }

    private void saveIngredientRefs(long shawarmaId, List<IngredientRef> ingredientRefs) {
        for (int i = 0; i < ingredientRefs.size(); i++) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, shawarma, shawarma_key) " +
                            "values (?, ?, ?)",
                    ingredientRefs.get(i).getIngredient(), shawarmaId, i);
        }
    }


}
