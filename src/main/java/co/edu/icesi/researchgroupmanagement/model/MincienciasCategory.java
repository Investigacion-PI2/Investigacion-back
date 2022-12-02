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
@Table(name = "minciencias_category")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MincienciasCategory implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MINCIENCIAS_CATEGORY_ID_GENERATOR", allocationSize = 1, sequenceName = "MINCIENCIAS_CATEGORY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GREAT_RAREA_ID_GENERATOR")
	private Long id;
	
	private String category;
	
	@OneToMany(mappedBy = "mincienciasCategory")
	private Set<ResearchGroup> researchGroups;

	public MincienciasCategory(Long id, String category) {
		this.id = id;
		this.category = category;
	}

}
