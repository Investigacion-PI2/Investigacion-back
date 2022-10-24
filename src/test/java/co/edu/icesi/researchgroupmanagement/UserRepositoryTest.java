package co.edu.icesi.researchgroupmanagement;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import co.edu.icesi.researchgroupmanagement.ResearchGroupManagementApplication;
import co.edu.icesi.researchgroupmanagement.model.Users;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = {ResearchGroupManagementApplication.class})
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate",
        "spring.datasource.initialization-mode=embedded"
})
class UserRepositoryTest {

//  @Autowired private DataSource dataSource;
//  @Autowired private JdbcTemplate jdbcTemplate;
  @Autowired private EntityManager entityManager;
  @Autowired private UserRepository userRepository;

  @Test
  void injectedComponentsAreNotNull(){
//    assertThat(dataSource).isNotNull();
//    assertThat(jdbcTemplate).isNotNull();
    assertThat(entityManager).isNotNull();
    assertThat(userRepository).isNotNull();
  }
  
  @Test
  void whenSaved_thenFindsByName() {
    userRepository.save(new Users(
            0, "testUsername1",
            null, null, null, null, null));
    assertThat(userRepository.findByUsername("testUsername1")).isNotNull();
    assertThat(userRepository.findById(0L)).isNotNull();
    assertThat(userRepository.findById(1L)).isNotNull();
  }
}