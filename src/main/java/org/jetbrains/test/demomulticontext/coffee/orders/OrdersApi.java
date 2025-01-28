package org.jetbrains.test.demomulticontext.coffee.orders;

import org.jetbrains.test.demomulticontext.coffee.orders.dto.OrderDto;
import org.jetbrains.test.demomulticontext.coffee.orders.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api")
class OrdersApi {
    private final OrderService orderService;

    public OrdersApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/orders", produces = "application/json")
    public ResponseEntity<Iterable<Order>> getAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @PostMapping("/orders/new")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        try {
            Order order = orderService.createOrder(orderDto);
            return ResponseEntity.ok(order);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity.status(500).body("Error in orders: " + ex.getMessage());
    }

}
