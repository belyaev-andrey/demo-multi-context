package org.jetbrains.test.demomulticontext;

import org.springframework.boot.SpringApplication;

public class TestDemoMultiContextApplication {

    public static void main(String[] args) {
        SpringApplication.from(DemoMultiContextApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
