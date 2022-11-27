package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.ResourceVisibility;


public interface ResourceVisibilityDao {
	public ResourceVisibility save(ResourceVisibility entity);
	public ResourceVisibility update(ResourceVisibility entity);
	public void delete (ResourceVisibility entity);
	public List<ResourceVisibility> findAll();
	public ResourceVisibility findById(Long id);
	public boolean existsById(Long id);
}
