package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.ResearchArea;


public interface ResearchAreaDao {
	public ResearchArea save(ResearchArea entity);
	public ResearchArea update(ResearchArea entity);
	public void delete (ResearchArea entity);
	public List<ResearchArea> findAll();
	public ResearchArea findById(Integer id);
	public boolean existsById(Integer id);
}