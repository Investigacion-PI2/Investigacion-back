package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.Resource;


public interface ResourceDao {
	public Resource save(Resource entity);
	public Resource update(Resource entity);
	public void delete (Resource entity);
	public List<Resource> findAll();
	public Resource findById(Integer id);
	public boolean existsById(Integer id);
}