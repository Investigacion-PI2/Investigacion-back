package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.FinancingSource;


public interface FinancingSourceDao {
	public FinancingSource save(FinancingSource fs);
	public FinancingSource update(FinancingSource fs);
	public void delete (FinancingSource fs);
	public List<FinancingSource> findAll();
	public FinancingSource findById(Integer id);
	public boolean existsById(Integer id);
}