package co.edu.icesi.researchgroupmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
//			Long l = (long) 1;
//			userRepository.save(new User(l,"1101100","15394725772654685941",l));
//			userTypeRepository.save(new UserType(l,"ESTU"));

		};
	}
}
