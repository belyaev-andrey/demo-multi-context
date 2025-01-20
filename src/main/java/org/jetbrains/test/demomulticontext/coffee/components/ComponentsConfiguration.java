package org.jetbrains.test.demomulticontext.coffee.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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