package co.edu.icesi.researchgroupmanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.researchgroupmanagement.daos.implementation.UserDaoImp;
import co.edu.icesi.researchgroupmanagement.model.User;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=validate",
//        "spring.datasource.initialization-mode=always"
//})
//@ContextConfiguration(classes = ResearchGroupManagementApplication.class)
//@ActiveProfiles("test")
//@TestPropertySource("/application.properties")
//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//@EnableAutoConfiguration(exclude=AutoConfigureTestDatabase.class)
//@SpringBootTest
//@ContextConfiguration(classes= UserDaoImp.class)
@ContextConfiguration(classes= UserDaoImp.class, loader=AnnotationConfigContextLoader.class)
public class UserDaoTest {

//  @Autowired
//	private DataSource dataSource;
//  @Autowired
//	private JdbcTemplate jdbcTemplate;
	
  @Autowired
  private EntityManager entityManager;
  
  @Autowired
  private UserDaoImp userDao;

  //@Test
  void injectedComponentsAreNotNull(){
//    assertThat(dataSource).isNotNull();
//    assertThat(jdbcTemplate).isNotNull();
    assertThat(entityManager).isNotNull();
    assertThat(userDao).isNotNull();
  }
  
  //@Test
  @Transactional
//  @Sql("data.sql")
  void whenSaved_thenFindsByName() {

	String user1Username = "testUsername1";
    userDao.save(new User(
    		user1Username,
    		"testFirstname1",
    		"testLastname1",
    		new Date(12345),
    		"testPassword1",
    		"testEmail1@email.com"));
    
    User extractedUser = userDao.findById((long)1);
    assertThat(extractedUser).isNotNull();
    assertEquals(1, extractedUser.getId());
    assertEquals(user1Username, extractedUser.getUsername());
    userDao.delete(extractedUser);
    assertThat(Optional.of(userDao.findByUsername(user1Username)).isEmpty());

    String user2Username = "testUsername2";
    userDao.save(new User(
    		user2Username,
    		"testFirstname2",
    		"testLastname2",
    		new Date(12345),
    		"testPassword2",
    		"testEmail2@email.com"));
    
    User extractedUser2 = userDao.findById((long)2);
    assertThat(extractedUser2).isNotNull();
    assertEquals(2, extractedUser2.getId());
    assertEquals(user2Username, extractedUser2.getUsername());
    userDao.delete(extractedUser);
    assertThat(Optional.of(userDao.findByUsername(user2Username)).isEmpty());
  }
}