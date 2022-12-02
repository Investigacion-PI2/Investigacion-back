package co.edu.icesi.researchgroupmanagement.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RESOURCE_VISIBILITY_ID_GENERATOR", allocationSize = 1, sequenceName = "RESOURCE_VISIBILITY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESOURCE_VISIBILITY_ID_GENERATOR")
	private Long id;
	
	private String visibility;
	
	@OneToMany(mappedBy = "resourceVisibility")
	private Set<Resource> resources;

	public ResourceVisibility(Long id, String visibility) {
		this.id = id;
		this.visibility = visibility;
	}

}
