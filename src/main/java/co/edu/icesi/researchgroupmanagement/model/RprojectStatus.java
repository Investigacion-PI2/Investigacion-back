package co.edu.icesi.researchgroupmanagement.model;

// Generated Oct 15, 2022, 11:56:22 PM by Hibernate Tools 5.6.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * RprojectStatus generated by hbm2java
 */
public class RprojectStatus implements java.io.Serializable {

	private long id;
	private String status;
	private Set researchProjects = new HashSet(0);

	public RprojectStatus() {
	}

	public RprojectStatus(long id, String status) {
		this.id = id;
		this.status = status;
	}

	public RprojectStatus(long id, String status, Set researchProjects) {
		this.id = id;
		this.status = status;
		this.researchProjects = researchProjects;
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

	public Set getResearchProjects() {
		return this.researchProjects;
	}

	public void setResearchProjects(Set researchProjects) {
		this.researchProjects = researchProjects;
	}

}
