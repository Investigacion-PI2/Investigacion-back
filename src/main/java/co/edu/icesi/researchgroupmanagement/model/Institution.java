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
@Table(name = "institution")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Institution implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "GREAT_RAREA_ID_GENERATOR", allocationSize = 1, sequenceName = "GREAT_RAREA_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GREAT_RAREA_ID_GENERATOR")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "institution")
	private Set<ResearchGroup> researchGroups;

	public Institution(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
