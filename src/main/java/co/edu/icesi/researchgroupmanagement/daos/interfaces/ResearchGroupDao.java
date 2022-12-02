package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;


public interface ResearchGroupDao {
	public ResearchGroup save(ResearchGroup rg);
	public ResearchGroup update(ResearchGroup rg);
	public void delete (ResearchGroup rg);
	public List<ResearchGroup> findAll();
	public ResearchGroup findById(Long rg);
	public boolean existsById(Long rg);
	List<ResearchGroup> findByFaculty(String name);
}
