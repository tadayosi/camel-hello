/*
 * Camel Api Route test generated by camel-api-component-maven-plugin
 * Generated on: Fri Mar 15 22:18:42 JST 2019
 */
package com.redhat.sample.camel.hello;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.sample.camel.hello.internal.HelloApiCollection;
import com.redhat.sample.camel.hello.internal.HelloFileHelloApiMethod;

/**
 * Test class for {@link com.redhat.sample.camel.hello.api.HelloFileHello} APIs.
 * TODO Move the file to src/test/java, populate parameter values, and remove @Ignore annotations.
 * The class source won't be generated again if the generator MOJO finds it under src/test/java.
 */
public class HelloFileHelloIntegrationTest extends AbstractHelloTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(HelloFileHelloIntegrationTest.class);
    private static final String PATH_PREFIX = HelloApiCollection.getCollection().getApiName(HelloFileHelloApiMethod.class).getName();

    // TODO provide parameter values for greetMe
    @Ignore
    @Test
    public void testGreetMe() throws Exception {
        // using String message body for single parameter "name"
        final String result = requestBody("direct://GREETME", null);

        assertNotNull("greetMe result", result);
        LOG.debug("greetMe: " + result);
    }

    // TODO provide parameter values for greetUs
    @Ignore
    @Test
    public void testGreetUs() throws Exception {
        final Map<String, Object> headers = new HashMap<String, Object>();
        // parameter type is String
        headers.put("CamelHello.name1", null);
        // parameter type is String
        headers.put("CamelHello.name2", null);

        final String result = requestBodyAndHeaders("direct://GREETUS", null, headers);

        assertNotNull("greetUs result", result);
        LOG.debug("greetUs: " + result);
    }

    @Ignore
    @Test
    public void testSayHi() throws Exception {
        final String result = requestBody("direct://SAYHI", null);

        assertNotNull("sayHi result", result);
        LOG.debug("sayHi: " + result);
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() {
                // test route for greetMe
                from("direct://GREETME")
                    .to("hello://" + PATH_PREFIX + "/greetMe?inBody=name");

                // test route for greetUs
                from("direct://GREETUS")
                    .to("hello://" + PATH_PREFIX + "/greetUs");

                // test route for sayHi
                from("direct://SAYHI")
                    .to("hello://" + PATH_PREFIX + "/sayHi");

            }
        };
    }
}
