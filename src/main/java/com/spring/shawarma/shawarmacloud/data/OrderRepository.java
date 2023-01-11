package com.spring.shawarma.shawarmacloud.data;

import com.spring.shawarma.shawarmacloud.ShawarmaOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ShawarmaOrder, Long> {
}
