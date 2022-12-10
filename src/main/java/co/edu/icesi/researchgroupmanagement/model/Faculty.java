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
@Table(name = "faculty")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Faculty implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FACULTY_ID_GENERATOR", allocationSize = 1, sequenceName = "FACULTY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACULTY_ID_GENERATOR")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "faculty")
	private Set<ResearchGroup> researchGroups;

	public Faculty(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
