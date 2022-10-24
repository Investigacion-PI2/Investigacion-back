package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import java.util.Set;

/**
 * ExternalAuthor generated by hbm2java
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ExternalAuthor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long id;
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "externalAuthors")
	private Set<Resource> resources;

	public ExternalAuthor() {
	}

	public ExternalAuthor(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public ExternalAuthor(long id, String firstName, String lastName, Set<Resource> resources) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.resources = resources;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

}
