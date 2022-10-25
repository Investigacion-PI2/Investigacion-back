package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ResearchLine generated by hbm2java
 */
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ResearchLine implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_area_id")
	private ResearchArea researchArea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_group_id")
	private ResearchGroup researchGroup;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "researchLine")
	private Set<ResearchProject> researchProjects;

	public ResearchLine() {
	}

	public ResearchLine(long id, ResearchGroup researchGroup, String name, String description) {
		this.id = id;
		this.researchGroup = researchGroup;
		this.name = name;
		this.description = description;
	}

	public ResearchLine(long id, ResearchArea researchArea, ResearchGroup researchGroup, String name,
			String description, Set<ResearchProject> researchProjects) {
		this.id = id;
		this.researchArea = researchArea;
		this.researchGroup = researchGroup;
		this.name = name;
		this.description = description;
		this.researchProjects = researchProjects;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ResearchArea getResearchArea() {
		return this.researchArea;
	}

	public void setResearchArea(ResearchArea researchArea) {
		this.researchArea = researchArea;
	}

	public ResearchGroup getResearchGroup() {
		return this.researchGroup;
	}

	public void setResearchGroup(ResearchGroup researchGroup) {
		this.researchGroup = researchGroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ResearchProject> getResearchProjects() {
		return this.researchProjects;
	}

	public void setResearchProjects(Set<ResearchProject> researchProjects) {
		this.researchProjects = researchProjects;
	}

}
