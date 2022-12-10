package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.Institution;


public interface InstitutionDao {
	public Institution save(Institution i);
	public Institution update(Institution i);
	public void delete (Institution i);
	public List<Institution> findAll();
	public Institution findById(Long id);
	public boolean existsById(Long id);
}
