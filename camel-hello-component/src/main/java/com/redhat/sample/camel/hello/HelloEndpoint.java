package com.redhat.sample.camel.hello;

import java.util.Map;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;
import org.apache.camel.util.component.AbstractApiEndpoint;
import org.apache.camel.util.component.ApiMethod;
import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import com.redhat.sample.camel.hello.api.HelloFileHello;
import com.redhat.sample.camel.hello.api.HelloJavadocHello;
import com.redhat.sample.camel.hello.internal.HelloApiCollection;
import com.redhat.sample.camel.hello.internal.HelloApiName;
import com.redhat.sample.camel.hello.internal.HelloConstants;
import com.redhat.sample.camel.hello.internal.HelloPropertiesHelper;

/**
 * Represents a Hello endpoint.
 */
@UriEndpoint(firstVersion = "1.0-SNAPSHOT", scheme = "hello", title = "Hello", syntax="hello:name", 
             consumerClass = HelloConsumer.class, label = "custom")
public class HelloEndpoint extends AbstractApiEndpoint<HelloApiName, HelloConfiguration> {

    @UriPath @Metadata(required = "true")
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public HelloEndpoint(String uri, HelloComponent component,
                         HelloApiName apiName, String methodName, HelloConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, HelloApiCollection.getCollection().getHelper(apiName), endpointConfiguration);

    }

    public Producer createProducer() throws Exception {
        return new HelloProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final HelloConsumer consumer = new HelloConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<HelloConfiguration> getPropertiesHelper() {
        return HelloPropertiesHelper.getHelper();
    }

    protected String getThreadProfileName() {
        return HelloConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO_FILE:
                apiProxy = new HelloFileHello();
                break;
            case HELLO_JAVADOC:
                apiProxy = new HelloJavadocHello();
                break;
            default:
                throw new IllegalArgumentException("Invalid API name " + apiName);
        }
    }

    @Override
    public Object getApiProxy(ApiMethod method, Map<String, Object> args) {
        return apiProxy;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
