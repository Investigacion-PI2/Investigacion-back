package co.edu.icesi.researchgroupmanagement.model;

// Generated Oct 15, 2022, 11:56:22 PM by Hibernate Tools 5.6.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * UserTypes generated by hbm2java
 */
@Entity
public class UserTypes implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private byte userTypesId;
	private long id;
	private String type;
	private Set userses = new HashSet(0);

	public UserTypes() {
	}

	public UserTypes(byte userTypesId, long id, String type) {
		this.userTypesId = userTypesId;
		this.id = id;
		this.type = type;
	}

	public UserTypes(byte userTypesId, long id, String type, Set userses) {
		this.userTypesId = userTypesId;
		this.id = id;
		this.type = type;
		this.userses = userses;
	}

	public byte getUserTypesId() {
		return this.userTypesId;
	}

	public void setUserTypesId(byte userTypesId) {
		this.userTypesId = userTypesId;
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

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}
