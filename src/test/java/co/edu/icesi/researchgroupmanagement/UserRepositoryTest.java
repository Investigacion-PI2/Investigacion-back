package co.edu.icesi.researchgroupmanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import co.edu.icesi.researchgroupmanagement.model.User;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=validate",
//        "spring.datasource.initialization-mode=always"
//})
//@ContextConfiguration(classes = ResearchGroupManagementApplication.class)
//@ActiveProfiles("test")
@TestPropertySource("/application.properties")
//@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//@ContextConfiguration(classes= ObjectAddressDaoImpl.class, loader=AnnotationConfigContextLoader.class)
@EnableAutoConfiguration(exclude=AutoConfigureTestDatabase.class)
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

	String user1Username = "testUsername1";
    userRepository.save(new User(
    		user1Username,
    		"testFirstname1",
    		"testLastname1",
    		new Date(12345),
    		"testPassword1",
    		"testEmail1@email.com"));
    
    User extractedUser = userRepository.findById(1L).get();
    assertThat(extractedUser).isNotNull();
    assertEquals(1, extractedUser.getId());
    assertEquals(user1Username, extractedUser.getUsername());
    userRepository.delete(extractedUser);
    assertThat(Optional.of(userRepository.findByUsername(user1Username)).isEmpty());

    String user2Username = "testUsername2";
    userRepository.save(new User(
    		user2Username,
    		"testFirstname2",
    		"testLastname2",
    		new Date(12345),
    		"testPassword2",
    		"testEmail2@email.com"));
    
    User extractedUser2 = userRepository.findById(2L).get();
    assertThat(extractedUser2).isNotNull();
    assertEquals(2, extractedUser2.getId());
    assertEquals(user2Username, extractedUser2.getUsername());
    userRepository.delete(extractedUser);
    assertThat(Optional.of(userRepository.findByUsername(user2Username)).isEmpty());
  }
}