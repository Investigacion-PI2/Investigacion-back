package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.GreatRarea;


public interface GreatRareaDao {
	public GreatRarea save(GreatRarea gra);
	public GreatRarea update(GreatRarea gra);
	public void delete (GreatRarea gra);
	public List<GreatRarea> findAll();
	public GreatRarea findById(Integer id);
	public boolean existsById(Integer id);
}