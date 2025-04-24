package br.com.gerador.leitor_csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class LeitorCsvApplication {

    public static void main(final String[] args) {
        SpringApplication.run(LeitorCsvApplication.class, args);
    }

}
