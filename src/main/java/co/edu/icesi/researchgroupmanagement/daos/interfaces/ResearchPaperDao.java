package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.ResearchPaper;


public interface ResearchPaperDao {
	public ResearchPaper save(ResearchPaper entity);
	public ResearchPaper update(ResearchPaper entity);
	public void delete (ResearchPaper entity);
	public List<ResearchPaper> findAll();
	public ResearchPaper findById(Long id);
	public boolean existsById(Long id);
}
