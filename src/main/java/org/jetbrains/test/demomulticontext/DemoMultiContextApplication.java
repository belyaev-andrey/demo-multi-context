package org.jetbrains.test.demomulticontext;

import org.jetbrains.test.demomulticontext.coffee.ShopConfiguration;
import org.jetbrains.test.demomulticontext.coffee.components.ComponentsConfiguration;
import org.jetbrains.test.demomulticontext.coffee.orders.OrdersConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

@SpringBootApplication
public class DemoMultiContextApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(DemoMultiContextApplication.class).web(WebApplicationType.NONE)
                .main(DemoMultiContextApplication.class)
                .child(ShopConfiguration.class).web(WebApplicationType.SERVLET)
                .sibling(OrdersConfiguration.class).web(WebApplicationType.NONE)
                .sibling(ComponentsConfiguration.class).web(WebApplicationType.NONE)
                .run(args);
    }

}

@Controller
@RequestMapping("/")
class RootController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<String> request() {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create("/api")).build();
    }

}