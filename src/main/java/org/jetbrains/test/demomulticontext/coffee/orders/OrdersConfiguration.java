package org.jetbrains.test.demomulticontext.coffee.orders;

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
    @GetMapping(path = "/api/orders", produces = "application/json")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok().body("Orders");
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity.status(500).body("Error in orders: "+ex.getMessage());
    }

}