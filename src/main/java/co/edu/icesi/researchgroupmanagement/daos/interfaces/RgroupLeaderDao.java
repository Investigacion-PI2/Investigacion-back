package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RgroupLeader;


public interface RgroupLeaderDao {
	public RgroupLeader save(RgroupLeader entity);
	public RgroupLeader update(RgroupLeader entity);
	public void delete (RgroupLeader entity);
	public List<RgroupLeader> findAll();
	public RgroupLeader findById(Integer id);
	public boolean existsById(Integer id);
}