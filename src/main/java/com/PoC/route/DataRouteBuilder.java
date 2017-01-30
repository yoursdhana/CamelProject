package com.PoC.route;

import org.apache.camel.builder.RouteBuilder;
import com.PoC.processor.DataProcessor;

public class DataRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer://Timer?repeatCount=1")
        .setBody(constant("select * from po_header_e"))
        .to("jdbc:lsdDB")
        .split(body())
        .choice()
        .when(body().convertToString().contains("tcin=1"))
        .setBody(constant("insert into po_loc_smry values (999999,9999,9,99,current_timestamp)"))
        .to("jdbc:vrsDB")
        .otherwise()
        .to("stream:out");
    }

}