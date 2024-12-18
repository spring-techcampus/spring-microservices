package com.alderaan.customer;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Customer Microservice - REST API Documentation",
		version = "${spring.application.version}",
		description = "Customer Microservice - REST API Documentation",
		contact = @Contact(
				name = "Alderaan",
				email = "test@test.com",
				url = "https://www.alderaan.com/"
		),
		license = @License(
				name = "Apache 2.0",
				url = "http://www.apache.org/licenses/LICENSE-2.0.html"
		)
),
		externalDocs = @ExternalDocumentation(
				description = "Customer Microservice Wiki",
				url = "https://www.alderaan.com/"
		)
)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
