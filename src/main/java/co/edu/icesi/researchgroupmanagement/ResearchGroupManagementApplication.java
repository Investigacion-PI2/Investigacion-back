package co.edu.icesi.researchgroupmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.icesi.researchgroupmanagement.model.User;
import co.edu.icesi.researchgroupmanagement.model.UserType;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;
import co.edu.icesi.researchgroupmanagement.repository.UserTypeRepository;

@SpringBootApplication
public class ResearchGroupManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchGroupManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner dummy(UserRepository userRepository, UserTypeRepository userTypeRepository) {
		return (args) -> {
			userTypeRepository.save(new UserType(1, "DEV"));

			User dev = new User("pandorah", "Pandorah", "Dark", null, "password", "pandorah.dark@gmail.com");
			dev.setUserType(userTypeRepository.findById((long) 1).get());
			userRepository.save(dev);
		};
	}
}
