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
@Table(name = "rproject_status")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RprojectStatus implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String status;
	
	@OneToMany(mappedBy = "rprojectStatus")
	private Set<ResearchProject> researchProjects;

	public RprojectStatus(long id, String status) {
		this.id = id;
		this.status = status;
	}

}
