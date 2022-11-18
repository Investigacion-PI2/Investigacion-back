package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RprojectGoal;


public interface RprojectGoalDao {
	public RprojectGoal save(RprojectGoal entity);
	public RprojectGoal update(RprojectGoal entity);
	public void delete (RprojectGoal entity);
	public List<RprojectGoal> findAll();
	public RprojectGoal findById(Integer id);
	public boolean existsById(Integer id);
}