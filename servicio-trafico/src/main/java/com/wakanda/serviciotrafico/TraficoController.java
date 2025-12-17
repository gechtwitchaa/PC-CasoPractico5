package com.wakanda.serviciotrafico;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraficoController {

    @GetMapping("/estado")
    @CircuitBreaker(name = "serviceTrafico", fallbackMethod = "planB")
    public String verTrafico() {
        return "Tráfico fluido en la ciudad inteligente.";
    }

    public String planB(Throwable e) {
        return "Modo manual activado";
    }
}