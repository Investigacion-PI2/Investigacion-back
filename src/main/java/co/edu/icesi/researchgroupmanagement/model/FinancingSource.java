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
@Table(name = "financing_source")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FinancingSource implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FINANCINGSOURCE_ID_GENERATOR", allocationSize = 1, sequenceName = "FINANCING_SOURCE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FINANCINGSOURCE_ID_GENERATOR")
	private Long id;
	
	private String source;
	
	@OneToMany(mappedBy = "financingSource")
	private Set<ResearchProject> researchProjects;

	public FinancingSource(Long id, String source) {
		this.id = id;
		this.source = source;
	}

}
