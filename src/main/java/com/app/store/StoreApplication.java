package com.app.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class StoreApplication {
    private static final Logger logger = LogManager.getLogger(StoreApplication.class);
    public static void main(String[] args) {

        logger.info("the store applictaion is started");
        SpringApplication.run(StoreApplication.class, args);
        logger.info("the store applictaion is ended");
    }

}
