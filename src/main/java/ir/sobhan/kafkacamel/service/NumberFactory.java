package ir.sobhan.kafkacamel.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberFactory {
    public int generateNumber(){
        Random random = new Random();
        return random.nextInt(100);
    }
}
