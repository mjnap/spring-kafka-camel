package ir.sobhan.kafkacamel;

import org.apache.camel.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaCamelApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaCamelApplication.class, args);
        runMainCamel(args);
    }

    public static void runMainCamel(String[] args) throws Exception {
        Main main = new Main();
        main.run(args);
    }
}
