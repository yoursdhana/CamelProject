package com.PoC;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.PoC.route.DataRouteBuilder;

//@SpringBootApplication
public class PurchaseOrderLoadApplication {
	

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(PurchaseOrderLoadApplication.class, args);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("camel-context.xml");
		  CamelContext camelctx =new SpringCamelContext(ctx);
    
    System.out.println("Application context started");
    try {
    	
    	camelctx.addRoutes(new DataRouteBuilder());
    	camelctx.start();
        Thread.sleep(5 * 60 * 1000);
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    }
    camelctx.stop();
   
	
  }
 
}