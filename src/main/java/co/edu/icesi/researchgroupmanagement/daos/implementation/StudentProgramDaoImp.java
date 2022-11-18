package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.StudentProgramDao;
import co.edu.icesi.researchgroupmanagement.model.StudentProgram;

@Repository
@Scope("singleton")
public class StudentProgramDaoImp implements StudentProgramDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public StudentProgram save(StudentProgram entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public StudentProgram update(StudentProgram entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void delete(StudentProgram entity) {
		em.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StudentProgram> findAll() {
		String query = "SELECT entity FROM student_program entity ORDER BY entity.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public StudentProgram findById(Integer entityId) {
		return em.find(StudentProgram.class, entityId);
	}

	@Override
	public boolean existsById(Integer entityId) {
		if (em.find(StudentProgram.class, entityId) != null)
			return true;
		return false;
	}

}