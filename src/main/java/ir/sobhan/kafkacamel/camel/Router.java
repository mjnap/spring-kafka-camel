package ir.sobhan.kafkacamel.camel;

import ir.sobhan.kafkacamel.camel.processors.AdderProcessor;
import ir.sobhan.kafkacamel.camel.processors.ConsumeProcessor;
import ir.sobhan.kafkacamel.service.NumberFactory;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Router extends RouteBuilder {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaUri;
    private final NumberFactory numberFactory;
    private final AdderProcessor adderProcessor;
    private final ConsumeProcessor consumeProcessor;

    @Override
    public void configure() throws Exception {
        producer();
        adder();
        consumer();
    }

    void producer(){
        from("scheduler://foo?delay=10000")
                .bean(numberFactory)
                .log("Produce number : ${body}")
                .to(kafkaUri);
    }

    void adder(){
        from(kafkaUri)
                .process(adderProcessor);
    }

    void consumer(){
        from("scheduler://foo?delay=60000")
                .delay(60000)
                .process(consumeProcessor)
                .log("Consumer sum : ${body}");
    }
}
