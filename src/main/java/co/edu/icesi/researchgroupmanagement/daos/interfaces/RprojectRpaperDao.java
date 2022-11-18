package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.RprojectRpaper;


public interface RprojectRpaperDao {
	public RprojectRpaper save(RprojectRpaper entity);
	public RprojectRpaper update(RprojectRpaper entity);
	public void delete (RprojectRpaper entity);
	public List<RprojectRpaper> findAll();
	public RprojectRpaper findById(Integer id);
	public boolean existsById(Integer id);
}