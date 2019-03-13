package com.redhat.sample.camel.hello;

import org.apache.camel.Processor;
import org.apache.camel.util.component.AbstractApiConsumer;

import com.redhat.sample.camel.hello.internal.HelloApiName;

/**
 * The Hello consumer.
 */
public class HelloConsumer extends AbstractApiConsumer<HelloApiName, HelloConfiguration> {

    public HelloConsumer(HelloEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
