package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RprojectType;


public interface RprojectTypeDao {
	public RprojectType save(RprojectType entity);
	public RprojectType update(RprojectType entity);
	public void delete (RprojectType entity);
	public List<RprojectType> findAll();
	public RprojectType findById(Long id);
	public boolean existsById(Long id);
}
