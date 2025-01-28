package org.jetbrains.test.demomulticontext.coffee.orders;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {
        "org.jetbrains.test.demomulticontext.coffee.orders",
        "org.jetbrains.test.demomulticontext.coffee.common"
})
@Configuration
@EnableAutoConfiguration
public class OrdersConfiguration {

}

