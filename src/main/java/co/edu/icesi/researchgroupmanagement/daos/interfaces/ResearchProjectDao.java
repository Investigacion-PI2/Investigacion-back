package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.ResearchProject;


public interface ResearchProjectDao {
	public ResearchProject save(ResearchProject entity);
	public ResearchProject update(ResearchProject entity);
	public void delete (ResearchProject entity);
	public List<ResearchProject> findAll();
	public ResearchProject findById(Integer id);
	public boolean existsById(Integer id);
}