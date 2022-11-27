package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.StudentProgram;


public interface StudentProgramDao {
	public StudentProgram save(StudentProgram entity);
	public StudentProgram update(StudentProgram entity);
	public void delete (StudentProgram entity);
	public List<StudentProgram> findAll();
	public StudentProgram findById(Long id);
	public boolean existsById(Long id);
}
