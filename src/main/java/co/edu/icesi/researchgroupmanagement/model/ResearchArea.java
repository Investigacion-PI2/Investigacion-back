package co.edu.icesi.researchgroupmanagement.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "research_area")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResearchArea implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RESEARCH_AREA_ID_GENERATOR", allocationSize = 1, sequenceName = "RESEARCH_AREA_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESEARCH_AREA_ID_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "great_rarea_id")
	private GreatRarea greatRarea;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "researchArea")
	private Set<ResearchLine> researchLines;

	public ResearchArea(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
