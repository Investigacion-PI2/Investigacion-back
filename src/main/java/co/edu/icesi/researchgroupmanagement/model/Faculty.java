package co.edu.icesi.researchgroupmanagement.model;

// Generated Oct 15, 2022, 11:56:22 PM by Hibernate Tools 5.6.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Faculty generated by hbm2java
 */
public class Faculty implements java.io.Serializable {

	private long id;
	private String name;
	private Set researchGroups = new HashSet(0);

	public Faculty() {
	}

	public Faculty(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Faculty(long id, String name, Set researchGroups) {
		this.id = id;
		this.name = name;
		this.researchGroups = researchGroups;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getResearchGroups() {
		return this.researchGroups;
	}

	public void setResearchGroups(Set researchGroups) {
		this.researchGroups = researchGroups;
	}

}
