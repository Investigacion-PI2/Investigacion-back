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
@Table(name = "financing_type")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FinancingType implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FINANCINGTYPE_ID_GENERATOR", allocationSize = 1, sequenceName = "FINANCING_TYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FINANCINGTYPE_ID_GENERATOR")
	private Long id;
	
	private String type;
	
	@OneToMany(mappedBy = "financingType")
	private Set<ResearchProject> researchProjects;

	public FinancingType(Long id, String type) {
		this.id = id;
		this.type = type;
	}

}
