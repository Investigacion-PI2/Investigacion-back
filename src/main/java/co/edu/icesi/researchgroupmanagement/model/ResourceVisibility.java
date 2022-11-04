package co.edu.icesi.researchgroupmanagement.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resource_visibilities")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVisibility implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String visibility;
	
	@OneToMany(mappedBy = "resourceVisibility")
	private Set<Resource> resources;

	public ResourceVisibility(long id, String visibility) {
		this.id = id;
		this.visibility = visibility;
	}

}
