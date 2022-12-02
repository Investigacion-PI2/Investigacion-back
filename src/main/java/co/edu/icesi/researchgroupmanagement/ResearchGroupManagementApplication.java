package co.edu.icesi.researchgroupmanagement;

import java.sql.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.icesi.researchgroupmanagement.daos.implementation.ResearchProjectDaoImp;
import co.edu.icesi.researchgroupmanagement.daos.implementation.RprojectUserDaoImp;
import co.edu.icesi.researchgroupmanagement.daos.implementation.UserDaoImp;
import co.edu.icesi.researchgroupmanagement.daos.implementation.UserTypeDaoImp;
import co.edu.icesi.researchgroupmanagement.model.ResearchProject;
import co.edu.icesi.researchgroupmanagement.model.RprojectUser;
import co.edu.icesi.researchgroupmanagement.model.User;
import co.edu.icesi.researchgroupmanagement.model.UserType;

@SpringBootApplication
public class ResearchGroupManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchGroupManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner dummy(
			UserDaoImp userDao, 
			ResearchProjectDaoImp rprojectDao, 
			RprojectUserDaoImp rprojectUserDao,
			UserTypeDaoImp utypeDao
			) {
		return (args) -> {			
//			utypeDao.save(new UserType(1, "DEV"));
//
//			User dev = new User("pandorah", "Pandorah", "Dark", null, "password", "pandorah.dark@gmail.com");
//			dev.setUserType(userTypeRepository.findById((long) 1).get());
//			userRepository.save(dev);
		};
	}
}
