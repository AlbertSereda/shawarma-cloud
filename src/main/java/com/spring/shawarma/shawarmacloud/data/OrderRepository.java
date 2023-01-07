package com.spring.shawarma.shawarmacloud.data;

import com.spring.shawarma.shawarmacloud.ShawarmaOrder;

public interface OrderRepository {
    ShawarmaOrder save(ShawarmaOrder shawarmaOrder);
}
