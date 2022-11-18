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
@Table(name = "rproject_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RprojectType implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RPROJECT_TYPE_ID_GENERATOR", allocationSize = 1, sequenceName = "RPROJECT_TYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RPROJECT_TYPE_ID_GENERATOR")
	private Long id;
	
	private String type;
	
	@OneToMany(mappedBy = "rprojectType")
	private Set<ResearchProject> researchProjects;

	public RprojectType(Long id, String type) {
		this.id = id;
		this.type = type;
	}

}
