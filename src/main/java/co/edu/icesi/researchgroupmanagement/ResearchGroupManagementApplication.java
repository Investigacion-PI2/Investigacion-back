package co.edu.icesi.researchgroupmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import co.edu.icesi.researchgroupmanagement.repository.UserRepository;
import co.edu.icesi.researchgroupmanagement.repository.UserTypeRepository;

@SpringBootApplication
public class ResearchGroupManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ResearchGroupManagementApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ResearchGroupManagementApplication.class);
	}

	@Bean
	CommandLineRunner dummy(UserRepository userRepository, UserTypeRepository userTypeRepository) {
		return (args) -> {
		};
	}
}
