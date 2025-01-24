package org.jetbrains.test.demomulticontext.coffee.components;

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
public class ComponentsConfiguration {

}

@RestController
class ComponentsApi {

    @GetMapping(path = "/api/components", produces = "application/json")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok().body("Components");
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity.status(500).body("Error in components: "+ex.getMessage());
    }
}

