package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.SciTiNationalProgram;


public interface SciTiNationalProgramDao {
	public SciTiNationalProgram save(SciTiNationalProgram stnp);
	public SciTiNationalProgram update(SciTiNationalProgram stnp);
	public void delete (SciTiNationalProgram stnp);
	public List<SciTiNationalProgram> findAll();
	public SciTiNationalProgram findById(Long id);
	public boolean existsById(Long id);
}
