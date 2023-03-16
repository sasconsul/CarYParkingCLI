package net.sasconsul.caryparking.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarYParkingCliApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory
            .getLogger(CarYParkingCliApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CarYParkingCliApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(" CarYParkingCliApplication called");

        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }
}
