package ir.sobhan.kafkacamel.camel.processors;

import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumeProcessor implements Processor {

    private final AdderProcessor adderProcessor;

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getMessage().setBody(adderProcessor.getSum());
        adderProcessor.setSum(0);
    }
}
