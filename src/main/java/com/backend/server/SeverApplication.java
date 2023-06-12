package com.backend.server;

//import com.backend.server.security.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeverApplication.class, args);
	}

	/*public CorsConfig corsConfig() {
		return new CorsConfig();
	}
*/
}
