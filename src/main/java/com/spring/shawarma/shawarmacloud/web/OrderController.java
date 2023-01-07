package com.spring.shawarma.shawarmacloud.web;

import com.spring.shawarma.shawarmacloud.ShawarmaOrder;
import com.spring.shawarma.shawarmacloud.data.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("shawarmaOrder")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid ShawarmaOrder order,
                               Errors errors,
                               SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        logger.info("Order submitted: {}", order);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
