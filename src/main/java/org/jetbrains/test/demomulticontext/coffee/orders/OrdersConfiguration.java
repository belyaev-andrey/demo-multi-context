package org.jetbrains.test.demomulticontext.coffee.orders;

import org.jetbrains.test.demomulticontext.coffee.orders.model.Order;
import org.jetbrains.test.demomulticontext.coffee.orders.model.OrdersRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class OrdersConfiguration {

}

@RestController
class OrdersApi {
    private final OrdersRepository ordersRepository;

    public OrdersApi(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping(path = "/api/orders", produces = "application/json")
    public ResponseEntity<Iterable<Order>> getAll() {
        return ResponseEntity.ok().body(ordersRepository.findAll());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity.status(500).body("Error in orders: "+ex.getMessage());
    }

}