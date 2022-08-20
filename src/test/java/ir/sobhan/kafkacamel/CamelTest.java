package ir.sobhan.kafkacamel;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class CamelTest extends CamelTestSupport {

    @Test
    public void testMock() throws Exception {
        getMockEndpoint("mock:kafka:numbers?brokers=Najafi-MJ:9092").expectedBodiesReceived(5);

        template.sendBody("direct:number", 5);

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:number")
                        .to("mock:kafka:numbers?brokers=Najafi-MJ:9092");
            }
        };
    }
}
