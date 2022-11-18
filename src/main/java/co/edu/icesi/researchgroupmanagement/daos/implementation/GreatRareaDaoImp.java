package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.GreatRareaDao;
import co.edu.icesi.researchgroupmanagement.model.GreatRarea;

@Repository
@Scope("singleton")
public class GreatRareaDaoImp implements GreatRareaDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public GreatRarea save(GreatRarea gra) {
		em.persist(gra);
		return gra;
	}

	@Override
	public GreatRarea update(GreatRarea gra) {
		em.merge(gra);
		return gra;
	}

	@Override
	public void delete(GreatRarea gra) {
		em.remove(gra);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GreatRarea> findAll() {
		String query = "SELECT gra FROM great_rarea gra ORDER BY gra.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public GreatRarea findById(Integer grareaId) {
		return em.find(GreatRarea.class, grareaId);
	}

	@Override
	public boolean existsById(Integer grareaId) {
		if (em.find(GreatRarea.class, grareaId) != null)
			return true;
		return false;
	}

}