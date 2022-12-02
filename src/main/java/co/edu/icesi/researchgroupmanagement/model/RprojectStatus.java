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
@Table(name = "rproject_status")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RprojectStatus implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RPROJECT_STATUS_ID_GENERATOR", allocationSize = 1, sequenceName = "RPROJECT_STATUS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RPROJECT_STATUS_ID_GENERATOR")
	private Long id;
	
	private String status;
	
	@OneToMany(mappedBy = "rprojectStatus")
	private Set<ResearchProject> researchProjects;

	public RprojectStatus(Long id, String status) {
		this.id = id;
		this.status = status;
	}

}
