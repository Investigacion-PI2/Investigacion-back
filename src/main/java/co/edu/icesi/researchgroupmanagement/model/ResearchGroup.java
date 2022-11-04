package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "research_group")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResearchGroup implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id")
	private Institution institution;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "minciencias_category_id")
	private MincienciasCategory mincienciasCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sci_ti_nprogram_id")
	private SciTiNationalProgram sciTiNationalProgram;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id")
	private User user;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "researchGroup")
	private Set<AdmissionRequest> admissionRequests;
	
	@OneToMany(mappedBy = "researchGroup")
	private Set<RgroupUser> rgroupUser;
	
	@OneToMany(mappedBy = "researchGroup")
	private Set<ResearchLine> researchLines;
	
	@OneToMany(mappedBy = "researchGroup")
	private Set<RgroupLeader> rgroupLeader;
	
	@ManyToMany
	@JoinTable(
			  name = "rgroup_rproject", 
			  joinColumns = @JoinColumn(name = "research_group_id"), 
			  inverseJoinColumns = @JoinColumn(name = "research_project_id"))
	private Set<ResearchProject> researchProjects;

	public ResearchGroup(long id, Faculty faculty, Institution institution, MincienciasCategory mincienciasCategory,
			User user, String name, String description) {
		this.id = id;
		this.faculty = faculty;
		this.institution = institution;
		this.mincienciasCategory = mincienciasCategory;
		this.user = user;
		this.name = name;
		this.description = description;
	}

}
