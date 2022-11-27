package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.Faculty;


public interface FacultyDao {
	public Faculty save(Faculty f);
	public Faculty update(Faculty f);
	public void delete (Faculty f);
	public List<Faculty> findAll();
	public Faculty findById(Long id);
	public boolean existsById(Long id);
}
