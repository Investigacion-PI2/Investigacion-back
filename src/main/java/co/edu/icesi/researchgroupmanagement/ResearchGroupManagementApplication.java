package co.edu.icesi.researchgroupmanagement;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.icesi.researchgroupmanagement.model.User;
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
//
//			  
//			Iterator<User> users = userRepository.findAll().iterator();
//			int i = 0;
//			for ( ; users.hasNext() ; ++i ) users.next();
//			System.out.println("users size: "+i);
		};
	}
}
