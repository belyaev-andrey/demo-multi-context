package org.jetbrains.test.demomulticontext.coffee.components;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan
@Configuration
public class ComponentsConfiguration {

}

@RestController
@RequestMapping("/api/components")
class ComponentsApi {

    @RequestMapping("")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok().body("Components");
    }

}