package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.AdmissionStatus;


public interface AdmissionStatusDao {
	public AdmissionStatus save(AdmissionStatus as);
	public AdmissionStatus update(AdmissionStatus as);
	public void delete (AdmissionStatus as);
	public List<AdmissionStatus> findAll();
	public AdmissionStatus findById(Integer id);
	public boolean existsById(Integer id);
}