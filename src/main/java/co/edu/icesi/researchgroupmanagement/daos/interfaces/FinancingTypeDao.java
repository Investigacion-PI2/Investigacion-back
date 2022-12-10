package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.FinancingType;


public interface FinancingTypeDao {
	public FinancingType save(FinancingType ft);
	public FinancingType update(FinancingType ft);
	public void delete (FinancingType ft);
	public List<FinancingType> findAll();
	public FinancingType findById(Long id);
	public boolean existsById(Long id);
}
