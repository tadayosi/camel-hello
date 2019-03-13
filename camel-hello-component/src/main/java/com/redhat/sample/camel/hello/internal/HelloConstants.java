package com.redhat.sample.camel.hello.internal;

/**
 * Constants for Hello component.
 */
public interface HelloConstants {

    // suffix for parameters when passed as exchange header properties
    String PROPERTY_PREFIX = "CamelHello.";

    // thread profile name for this component
    String THREAD_PROFILE_NAME = "CamelHello";
}
