package org.jetbrains.test.demomulticontext.coffee.components;

import org.jetbrains.test.demomulticontext.coffee.components.model.Component;
import org.jetbrains.test.demomulticontext.coffee.components.model.ComponentsRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableJdbcRepositories
public class ComponentsConfiguration {

}

@RestController
class ComponentsApi {

    private final ComponentsRepository componentsRepository;

    public ComponentsApi(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    @GetMapping(path = "/api/components", produces = "application/json")
    public ResponseEntity<Iterable<Component>> getAll() {
        Iterable<Component> allComponents = componentsRepository.findAll();
        return ResponseEntity.ok().body(allComponents);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity.status(500).body("Error in components: "+ex.getMessage());
    }
}

