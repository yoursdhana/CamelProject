package com.PoC.processor; 

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DataProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("process method called");
    }

}