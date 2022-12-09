package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RprojectRprojectStatus;

public interface RprojectRprojectStatusDao {

	void save(RprojectRprojectStatus entity);

	void update(RprojectRprojectStatus entity);
	
	List<RprojectRprojectStatus> findChangesByProject(Long projectId);
}
