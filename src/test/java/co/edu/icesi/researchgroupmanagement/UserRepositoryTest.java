package co.edu.icesi.researchgroupmanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import co.edu.icesi.researchgroupmanagement.model.Users;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=validate",
//        "spring.datasource.initialization-mode=always"
//})
//@ContextConfiguration(classes = ResearchGroupManagementApplication.class)
//@ActiveProfiles("test")
public class UserRepositoryTest {

//  @Autowired
//	private DataSource dataSource;
//  @Autowired
//	private JdbcTemplate jdbcTemplate;
	
  @Autowired
  private EntityManager entityManager;
  
  @Autowired
  private UserRepository userRepository;

  @Test
  void injectedComponentsAreNotNull(){
//    assertThat(dataSource).isNotNull();
//    assertThat(jdbcTemplate).isNotNull();
    assertThat(entityManager).isNotNull();
    assertThat(userRepository).isNotNull();
  }
  
  @Test
//  @Sql("data.sql")
  void whenSaved_thenFindsByName() {
	  
    userRepository.save(new Users(
    		"testUsername1",
    		"testFirstname1",
    		"testLastname1",
    		new Date(12345),
    		"testPassword1",
    		"testEmail1@email.com"));
    
    Users extractedUser = userRepository.findById(1L).get();
    assertThat(extractedUser).isNotNull();
    assertEquals(1, extractedUser.getId());
    assertEquals("testUsername1", extractedUser.getUsername());

    userRepository.save(new Users(
    		"testUsername2",
    		"testFirstname2",
    		"testLastname2",
    		new Date(12345),
    		"testPassword2",
    		"testEmail2@email.com"));
    
    Users extractedUser2 = userRepository.findById(2L).get();
    assertThat(extractedUser2).isNotNull();
    assertEquals(2, extractedUser2.getId());
    assertEquals("testUsername2", extractedUser2.getUsername());
  }
}