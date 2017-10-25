package com;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * @author Ignacio González - igonzalez@emergya.com
 * @since 3/08/17
 */
@MessagingGateway(defaultRequestChannel="toTcp")
public interface SimpleGateway {

    String send(String in);
}
