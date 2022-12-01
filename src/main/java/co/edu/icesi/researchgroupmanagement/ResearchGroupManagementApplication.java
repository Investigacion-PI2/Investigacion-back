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
import co.edu.icesi.researchgroupmanagement.model.ResearchProject;
import co.edu.icesi.researchgroupmanagement.model.RprojectUser;
import co.edu.icesi.researchgroupmanagement.model.User;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;
import co.edu.icesi.researchgroupmanagement.repository.UserTypeRepository;

@SpringBootApplication
public class ResearchGroupManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchGroupManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner dummy(UserDaoImp userDao, ResearchProjectDaoImp rprojectDao, RprojectUserDaoImp rprojectUserDao) {
		return (args) -> {
//
//			  
//			Iterator<User> users = userRepository.findAll().iterator();
//			int i = 0;
//			for ( ; users.hasNext() ; ++i ) users.next();
//			System.out.println("users size: "+i);
			
			// Only uncomment the following if using H2.
//			ResearchProject rp = new ResearchProject();
//			rp.setTitle("Titulo");
//			rp.setDescription("Descripción");
//			
//			rprojectDao.save(rp);
//			
//			User u = new User();
//			u.setUsername("username1");
//			u.setFirstName("name1");
//			u.setLastName("lastname1");
//			u.setDob(new Date(System.currentTimeMillis()));		
//			u.setPassword("123");
//			u.setEmail("email@example.com");
//			
//			userDao.save(u);
//			ResearchProject rp2 = new ResearchProject();
//			rp2.setId(Long.valueOf(1));
//			
////			ar.setResearchProject(rp2);
////			
//			User u2 = new User();
//			u2.setId(Long.valueOf(2));
////			
////			ar.setUser(u1);
////			admissionrequestservice.save(ar);
//			RprojectUser pu = new RprojectUser();
//			pu.setMemberRole("Estudiante");
//			
//			pu.setResearchProject(rp2);
//			pu.setUser(u);
//			
//			rprojectUserDao.save(pu);
//			System.out.println(userDao.findAll().size());
		};
	}
}
