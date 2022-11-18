package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.FacultyDao;
import co.edu.icesi.researchgroupmanagement.model.Faculty;

@Repository
@Scope("singleton")
public class FacultyDaoImp implements FacultyDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Faculty save(Faculty f) {
		em.persist(f);
		return f;
	}

	@Override
	public Faculty update(Faculty f) {
		em.merge(f);
		return f;
	}

	@Override
	public void delete(Faculty f) {
		em.remove(f);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Faculty> findAll() {
		String query = "SELECT f FROM faculty f ORDER BY f.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Faculty findById(Integer facultyId) {
		return em.find(Faculty.class, facultyId);
	}

	@Override
	public boolean existsById(Integer facultyId) {
		if (em.find(Faculty.class, facultyId) != null)
			return true;
		return false;
	}

}