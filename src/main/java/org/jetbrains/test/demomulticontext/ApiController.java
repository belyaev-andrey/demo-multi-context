package org.jetbrains.test.demomulticontext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("Success");
    }


}
