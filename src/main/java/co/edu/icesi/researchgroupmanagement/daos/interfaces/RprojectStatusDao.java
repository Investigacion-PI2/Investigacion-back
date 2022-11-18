package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RprojectStatus;


public interface RprojectStatusDao {
	public RprojectStatus save(RprojectStatus entity);
	public RprojectStatus update(RprojectStatus entity);
	public void delete (RprojectStatus entity);
	public List<RprojectStatus> findAll();
	public RprojectStatus findById(Integer id);
	public boolean existsById(Integer id);
}