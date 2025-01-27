package org.jetbrains.test.demomulticontext;

import org.jetbrains.test.demomulticontext.coffee.components.ComponentsConfiguration;
import org.jetbrains.test.demomulticontext.coffee.orders.OrdersConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoMultiContextApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .main(DemoMultiContextApplication.class)
                    .sources(DemoMultiContextApplication.class)
                    .web(WebApplicationType.NONE)
                .child(ComponentsConfiguration.class)
                    .web(WebApplicationType.SERVLET)
                    .profiles("components")
                .sibling(OrdersConfiguration.class)
                    .web(WebApplicationType.SERVLET)
                    .profiles("orders")
                .run(args);
    }
}