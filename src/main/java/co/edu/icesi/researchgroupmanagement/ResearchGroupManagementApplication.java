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
			
//			User user1 = new User();
//			User user2 = new User();
//			ResearchProject project1 = new ResearchProject();
//			RprojectUser rprojectUser1 = new RprojectUser();
//			
//			userDao.save(user1);
//			user1 = userDao.findById(1L);
////			user1.setId(1L);
//			rprojectDao.save(project1);
//			project1 = rprojectDao.findById(1L);
////			project1.setId(1L);
//			
//			rprojectUser1.setUser(user1);
//			rprojectUser1.setResearchProject(project1);
//			rprojectUserDao.save(rprojectUser1);
			
			
			ResearchProject rp = new ResearchProject();
			//rp.setId(Long.valueOf(1));
			rp.setTitle("Titulo");
			rp.setDescription("Descripción");
			
			rprojectDao.save(rp);
			
			User u = new User();
			//u.setId(Long.valueOf(1));
			u.setUsername("Zonitidus");
			u.setFirstName("Esteban");
			u.setLastName("Yusunguaira");
			u.setDob(new Date(System.currentTimeMillis()));		
			u.setPassword("juju");
			u.setEmail("email@example.com");
			
			userDao.save(u);
ResearchProject rp2 = new ResearchProject();
			rp2.setId(Long.valueOf(1));
			
//			ar.setResearchProject(rp2);
//			
			User u1 = new User();
			u1.setId(Long.valueOf(1));
//			
//			ar.setUser(u1);
//			
//			
//			admissionrequestservice.save(ar);
//			
			RprojectUser pu = new RprojectUser();
			pu.setMemberRole("Estudiante");
			
			pu.setResearchProject(rp2);
			pu.setUser(u1);
			
			rprojectUserDao.save(pu);
		};
	}
}
