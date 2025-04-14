package com.kneuroth.pizza_vote.checks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DatasourceCheckConfig {

    // (Used for prod) Check if h2 is being used
    @Bean
    public CommandLineRunner verifyDatabase(DataSource ds) {
        return args -> {
            String url = ds.getConnection().getMetaData().getURL();
            if (url.contains("h2")) {
                throw new IllegalStateException("H2 fallback detected in production!");
            } else {
                System.out.println("✅ Connected to proper database: " + url);
            }
        };
    }
}
