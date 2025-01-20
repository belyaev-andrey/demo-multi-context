package org.jetbrains.test.demomulticontext.coffee.orders;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@Configuration
public class OrdersConfiguration {

}

@RestController
@RequestMapping("/api/orders")
class OrdersApi {
    @RequestMapping("")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok().body("Orders");
    }
}