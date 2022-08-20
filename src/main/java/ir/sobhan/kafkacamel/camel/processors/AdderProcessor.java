package ir.sobhan.kafkacamel.camel.processors;

import lombok.Getter;
import lombok.Setter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AdderProcessor implements Processor {

    private int sum = 0;

    @Override
    public void process(Exchange exchange) throws Exception {
        int number = exchange.getMessage().getBody(Integer.class);
        sum += number;
        exchange.getMessage().setBody(sum);
    }
}
