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
@Table(name = "sci_ti_national_program")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SciTiNationalProgram implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "sciTiNationalProgram")
	private Set<ResearchGroup> researchGroups;

	public SciTiNationalProgram(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
}
