package com.wakanda.serviciotrafico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicioTraficoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioTraficoApplication.class, args);
    }
}