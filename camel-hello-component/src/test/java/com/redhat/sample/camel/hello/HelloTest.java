package com.redhat.sample.camel.hello;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class HelloTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // @formatter:off
                from("direct:sayHello")
                    .setHeader("CamelHello.name1", constant("Llama"))
                    .setHeader("CamelHello.name2", constant("Alpaca"))
                    .to("hello://hello-file/greetUs")
                    .log("${body}");
                // @formatter:on
            }
        };
    }

    @Test
    public void sayHello() throws Exception {
        template.sendBody("direct:sayHello", null);
    }
}
