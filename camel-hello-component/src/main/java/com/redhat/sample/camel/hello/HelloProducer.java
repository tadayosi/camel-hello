package com.redhat.sample.camel.hello;

import org.apache.camel.util.component.AbstractApiProducer;

import com.redhat.sample.camel.hello.internal.HelloApiName;
import com.redhat.sample.camel.hello.internal.HelloPropertiesHelper;

/**
 * The Hello producer.
 */
public class HelloProducer extends AbstractApiProducer<HelloApiName, HelloConfiguration> {

    public HelloProducer(HelloEndpoint endpoint) {
        super(endpoint, HelloPropertiesHelper.getHelper());
    }
}
