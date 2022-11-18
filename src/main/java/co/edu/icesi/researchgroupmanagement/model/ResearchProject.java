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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private static final Long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "RESEARCH_PROJECT_ID_GENERATOR", allocationSize = 1, sequenceName = "RESEARCH_PROJECT_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESEARCH_PROJECT_ID_GENERATOR")
	private Long id;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<AdmissionRequest> admissionRequests;
	
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
	
	
	@NotNull
	private String title;
	@NotNull
	private String description;
	@PastOrPresent
	private Date startDate;
	@Future
	private Date finishDate;
	
	@ManyToMany(mappedBy = "researchProjects")
	private Set<ResearchGroup> researchGroups;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<RprojectRpaper> rprojectRpapers;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<Resource> resources;
	
	@OneToMany(mappedBy = "researchProject", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","researchProject"}, allowSetters = true)
	private Set<RprojectGoal> rprojectGoals;
	
	@OneToMany(mappedBy = "researchProject")
	private Set<RprojectUser> rRprojectUser;

	@JsonCreator
	public ResearchProject(Long id, String title, String description, Date startDate, Set<RprojectGoal> rprojectGoals) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.rprojectGoals = rprojectGoals;
	}

}
