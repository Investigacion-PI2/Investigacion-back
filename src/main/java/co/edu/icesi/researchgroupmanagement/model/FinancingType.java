package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:23:43 PM by Hibernate Tools 5.6.7.Final

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.HashSet;
import java.util.Set;

/**
 * FinancingType generated by hbm2java
 */
@Entity
public class FinancingType implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long id;
	private String type;
	private Set researchProjects = new HashSet(0);

	public FinancingType() {
	}

	public FinancingType(long id, String type) {
		this.id = id;
		this.type = type;
	}

	public FinancingType(long id, String type, Set researchProjects) {
		this.id = id;
		this.type = type;
		this.researchProjects = researchProjects;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getResearchProjects() {
		return this.researchProjects;
	}

	public void setResearchProjects(Set researchProjects) {
		this.researchProjects = researchProjects;
	}

}