package org.jetbrains.test.demomulticontext.coffee.components;

import org.jetbrains.test.demomulticontext.coffee.common.PaymentStatus;
import org.jetbrains.test.demomulticontext.coffee.components.dto.BuyRequest;
import org.jetbrains.test.demomulticontext.coffee.components.model.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
class ComponentsApi {

    private final ComponentsService componentsService;

    public ComponentsApi(ComponentsService componentsService) {
        this.componentsService = componentsService;
    }

    @GetMapping(path = "/components", produces = "application/json")
    public ResponseEntity<Iterable<Component>> getAll() {
        Iterable<Component> allComponents = componentsService.findAll();
        return ResponseEntity.ok().body(allComponents);
    }

    @PostMapping("/components/buy")
    public ResponseEntity<PaymentStatus> buyComponent(@RequestBody BuyRequest buyRequest) {
        PaymentStatus paymentStatus = componentsService.buyComponent(buyRequest.componentId());
        if (paymentStatus == PaymentStatus.FAILED) {
            return ResponseEntity.status(402).body(paymentStatus);
        }
        return ResponseEntity.ok(paymentStatus);
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(Exception ex) {
        return ResponseEntity.status(500).body("Error in components: " + ex.getMessage());
    }
}
