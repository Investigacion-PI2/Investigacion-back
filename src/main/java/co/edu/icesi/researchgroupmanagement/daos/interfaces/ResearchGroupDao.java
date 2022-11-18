package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;


public interface ResearchGroupDao {
	public ResearchGroup save(ResearchGroup rg);
	public ResearchGroup update(ResearchGroup rg);
	public void delete (ResearchGroup rg);
	public List<ResearchGroup> findAll();
	public ResearchGroup findById(Integer rg);
	public boolean existsById(Integer rg);
	List<ResearchGroup> findByFaculty(String name);
}