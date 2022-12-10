package co.edu.icesi.researchgroupmanagement.daos.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.daos.interfaces.SciTiNationalProgramDao;
import co.edu.icesi.researchgroupmanagement.model.SciTiNationalProgram;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("singleton")
@Transactional
public class SciTiNationalProgramDaoImp implements SciTiNationalProgramDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public SciTiNationalProgram save(SciTiNationalProgram stnp) {
		em.persist(stnp);
		return stnp;
	}

	@Override
	public SciTiNationalProgram update(SciTiNationalProgram stnp) {
		em.merge(stnp);
		return stnp;
	}

	@Override
	public void delete(SciTiNationalProgram stnp) {
		em.remove(stnp);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SciTiNationalProgram> findAll() {
		String query = "SELECT stnp FROM sci_ti_national_program stnp ORDER BY stnp.id";
		return em.createQuery(query).getResultList();
	}

	@Override
	public SciTiNationalProgram findById(Long stnpId) {
		return em.find(SciTiNationalProgram.class, stnpId);
	}

	@Override
	public boolean existsById(Long stnpId) {
		if (em.find(SciTiNationalProgram.class, stnpId) != null)
			return true;
		return false;
	}

}
