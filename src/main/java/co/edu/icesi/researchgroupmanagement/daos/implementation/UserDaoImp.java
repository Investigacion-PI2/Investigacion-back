package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.UserDao;
import co.edu.icesi.researchgroupmanagement.model.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class UserDaoImp implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User save(User u) {
		em.persist(u);
		return u;
	}

	@Override
	public User update(User u) {
		em.merge(u);
		return u;
	}

	@Override
	public void delete(User u) {
		em.remove(u);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String query = "SELECT u FROM users u ORDER BY u.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public User findById(Long userId) {
		return em.find(User.class, userId);
	}

	@Override
	public boolean existsById(Long userId) {
		if (em.find(User.class, userId) != null)
			return true;
		return false;
	}
	
	@Override
	public User findByUsername(String username) {
		String jpql = "SELECT u FROM users u " +
				  "WHERE u.username=:username";
	Query query = em.createQuery(jpql);
	query.setParameter("username", username);
	return (User) query.getSingleResult();
	}
}
