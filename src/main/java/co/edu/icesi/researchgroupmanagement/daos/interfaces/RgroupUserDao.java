package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RgroupUser;


public interface RgroupUserDao {
	public RgroupUser save(RgroupUser entity);
	public RgroupUser update(RgroupUser entity);
	public void delete (RgroupUser entity);
	public List<RgroupUser> findAll();
	public RgroupUser findById(Long id);
	public boolean existsById(Long id);
}
