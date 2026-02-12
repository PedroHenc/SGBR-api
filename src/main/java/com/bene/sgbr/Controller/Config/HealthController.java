package com.bene.sgbr.Controller.Config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/health/db")
    public String healthDb() {
        Integer one = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return "db_ok=" + one;
    }
}