package com;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

/**
 * @author Ignacio González - igonzalez@emergya.com
 * @since 3/08/17
 */
@MessageEndpoint
public class Echo {

    @Transformer(inputChannel="fromTcp", outputChannel="toEcho")
    public String convert(byte[] bytes) {
        return new String(bytes);
    }

    @ServiceActivator(inputChannel="toEcho")
    public String upCase(String in) throws InterruptedException {
        System.out.println(in);
        Thread.sleep(5000);
        return "ACK:" + in.toUpperCase();
    }

    @Transformer(inputChannel="resultToString")
    public String convertResult(byte[] bytes) {
        return new String(bytes);
    }

}