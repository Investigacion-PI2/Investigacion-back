package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.RprojectRprojectStatusDao;
import co.edu.icesi.researchgroupmanagement.model.RprojectRprojectStatus;

@Repository
@Scope("singleton")
@Transactional
public class RprojectRprojectStatusDaoImp implements RprojectRprojectStatusDao {

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(RprojectRprojectStatus entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(RprojectRprojectStatus entity) {
		entityManager.merge(entity);
	}

	@Override
	public List<RprojectRprojectStatus> findChangesByProject(Long projectId) {
		
		String jpql = "Select rprps from RprojectRprojectStatus rprps where rprps.researchProject.id=:id";
		Query query =	entityManager.createQuery(jpql);
		query.setParameter("id", projectId);
		
		return query.getResultList();
	}
	
}
