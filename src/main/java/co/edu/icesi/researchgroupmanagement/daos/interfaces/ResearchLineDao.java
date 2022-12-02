package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.ResearchLine;


public interface ResearchLineDao {
	public ResearchLine save(ResearchLine entity);
	public ResearchLine update(ResearchLine entity);
	public void delete (ResearchLine entity);
	public List<ResearchLine> findAll();
	public ResearchLine findById(Long id);
	public boolean existsById(Long id);
}
