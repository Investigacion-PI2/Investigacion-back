package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * AdmissionStatus generated by hbm2java
 */
import javax.persistence.OneToMany;


@Entity
public class AdmissionStatus implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String status;
	
	@OneToMany(mappedBy = "admissionStatus")
	private Set<AdmissionRequest> admissionRequests;

	public AdmissionStatus() {
	}

	public AdmissionStatus(long id, String status) {
		this.id = id;
		this.status = status;
	}

	public AdmissionStatus(long id, String status, Set<AdmissionRequest> admissionRequests) {
		this.id = id;
		this.status = status;
		this.admissionRequests = admissionRequests;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<AdmissionRequest> getAdmissionRequests() {
		return this.admissionRequests;
	}

	public void setAdmissionRequests(Set<AdmissionRequest> admissionRequests) {
		this.admissionRequests = admissionRequests;
	}

}
