package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.AdmissionRequest;


public interface AdmissionRequestDao {
	public AdmissionRequest save(AdmissionRequest entity);
	public AdmissionRequest update(AdmissionRequest entity);
	public void delete (AdmissionRequest entity);
	public List<AdmissionRequest> findAll();
	public AdmissionRequest findById(Long id);
	public boolean existsById(Long id);
}
