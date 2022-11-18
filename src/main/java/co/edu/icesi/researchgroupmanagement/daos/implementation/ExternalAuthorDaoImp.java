package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.ExternalAuthorDao;
import co.edu.icesi.researchgroupmanagement.model.ExternalAuthor;

@Repository
@Scope("singleton")
public class ExternalAuthorDaoImp implements ExternalAuthorDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ExternalAuthor save(ExternalAuthor ea) {
		em.persist(ea);
		return ea;
	}

	@Override
	public ExternalAuthor update(ExternalAuthor ea) {
		em.merge(ea);
		return ea;
	}

	@Override
	public void delete(ExternalAuthor ea) {
		em.remove(ea);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ExternalAuthor> findAll() {
		String query = "SELECT ea FROM external_author ea ORDER BY ea.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public ExternalAuthor findById(Integer eauthorId) {
		return em.find(ExternalAuthor.class, eauthorId);
	}

	@Override
	public boolean existsById(Integer eauthorId) {
		if (em.find(ExternalAuthor.class, eauthorId) != null)
			return true;
		return false;
	}

}