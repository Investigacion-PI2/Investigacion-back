package co.edu.icesi.researchgroupmanagement.model;

// Generated Oct 15, 2022, 11:56:22 PM by Hibernate Tools 5.6.7.Final

import java.util.Date;

/**
 * AdmissionRequest generated by hbm2java
 */
public class AdmissionRequest implements java.io.Serializable {

	private long id;
	private AdmissionStatus admissionStatus;
	private ResearchGroup researchGroup;
	private Users users;
	private String description;
	private Date startDate;
	private Date finishDate;

	public AdmissionRequest() {
	}

	public AdmissionRequest(long id, Date startDate) {
		this.id = id;
		this.startDate = startDate;
	}

	public AdmissionRequest(long id, AdmissionStatus admissionStatus, ResearchGroup researchGroup, Users users,
			String description, Date startDate, Date finishDate) {
		this.id = id;
		this.admissionStatus = admissionStatus;
		this.researchGroup = researchGroup;
		this.users = users;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AdmissionStatus getAdmissionStatus() {
		return this.admissionStatus;
	}

	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public ResearchGroup getResearchGroup() {
		return this.researchGroup;
	}

	public void setResearchGroup(ResearchGroup researchGroup) {
		this.researchGroup = researchGroup;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return this.finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
