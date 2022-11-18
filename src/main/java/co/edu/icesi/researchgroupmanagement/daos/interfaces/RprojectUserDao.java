package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RprojectUser;


public interface RprojectUserDao {
	public RprojectUser save(RprojectUser entity);
	public RprojectUser update(RprojectUser entity);
	public void delete (RprojectUser entity);
	public List<RprojectUser> findAll();
	public RprojectUser findById(Integer id);
	public boolean existsById(Integer id);
}