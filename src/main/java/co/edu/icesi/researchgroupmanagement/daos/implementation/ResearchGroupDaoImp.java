package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ResearchGroupDao;
import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class ResearchGroupDaoImp implements ResearchGroupDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ResearchGroup save(ResearchGroup rg) {
		em.persist(rg);
		return rg;
	}

	@Override
    @Transactional
	public ResearchGroup update(ResearchGroup rg) {
		em.merge(rg);
		return rg;
	}

	@Override
    @Transactional
	public void delete(ResearchGroup rg) {
		em.remove(rg);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResearchGroup> findAll() {
		String query = "SELECT rg FROM research_group rg ORDER BY rg.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ResearchGroup findById(Long rgroupId) {
		return em.find(ResearchGroup.class, rgroupId);
	}

//  public ResearchGroup findById(Long id) {
//      String jpql = "SELECT rg FROM research_group rg WHERE rg.id = :id";
//      Query q = entityManager.createQuery(jpql);
//      q.setParameter("id", id);
//      return (ResearchGroup) q.getSingleResult();
//  }

	@Override
	public boolean existsById(Long rgroupId) {
		if (em.find(ResearchGroup.class, rgroupId) != null)
			return true;
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
    public List<ResearchGroup> findByFaculty(String name) {
        String jpql = "SELECT rg FROM research_group rg WHERE rg.faculty.name = :name";
        Query query = em.createQuery(jpql);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
