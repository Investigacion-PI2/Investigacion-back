package co.edu.icesi.researchgroupmanagement.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "research_project")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResearchProject implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "financing_source_id")
	private FinancingSource financingSource;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "financing_type_id")
	private FinancingType financingType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_line_id")
	private ResearchLine researchLine;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rproject_status_id")
	private RprojectStatus rprojectStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rproject_type_id")
	private RprojectType rprojectType;
	
	private String title;
	private String description;
	private Date startDate;
	private Date finishDate;
	
	@ManyToMany(mappedBy = "researchProjects")
	private Set<ResearchGroup> researchGroups;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<RprojectRpaper> rprojectRpapers;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<Resource> resources;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<RprojectGoal> rprojectGoals;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<RprojectUser> rprojectUsers;

	public ResearchProject(long id, String title, String description, Date startDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
	}

}
