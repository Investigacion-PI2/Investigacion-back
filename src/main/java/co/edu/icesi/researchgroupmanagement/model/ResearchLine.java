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
@Table(name = "research_line")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResearchLine implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_area_id")
	private ResearchArea researchArea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_group_id")
	private ResearchGroup researchGroup;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "researchLine")
	private Set<ResearchProject> researchProjects;

	public ResearchLine(long id, ResearchGroup researchGroup, String name, String description) {
		this.id = id;
		this.researchGroup = researchGroup;
		this.name = name;
		this.description = description;
	}

}
