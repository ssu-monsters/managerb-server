/*package com.backend.server;

import com.backend.server.repository.SpRepository;
import com.backend.server.service.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SpringConfig {
    private final SpRepository spRepository;
    @Autowired
    public SpringConfig(SpRepository spRepository) {
        this.spRepository = spRepository;
    }

    @Bean
    public SpService spService(){
        return new SpService((spRepository));
    }
}
*/