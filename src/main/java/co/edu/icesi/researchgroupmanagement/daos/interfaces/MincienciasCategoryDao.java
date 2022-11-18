package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.MincienciasCategory;


public interface MincienciasCategoryDao {
	public MincienciasCategory save(MincienciasCategory mcat);
	public MincienciasCategory update(MincienciasCategory mat);
	public void delete (MincienciasCategory mcat);
	public List<MincienciasCategory> findAll();
	public MincienciasCategory findById(Integer id);
	public boolean existsById(Integer id);
}