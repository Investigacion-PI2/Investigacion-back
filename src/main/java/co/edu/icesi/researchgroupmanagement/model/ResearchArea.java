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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "great_rarea_id")
	private GreatRarea greatRarea;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "researchArea")
	private Set<ResearchLine> researchLines;

	public ResearchArea(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
