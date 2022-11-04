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
@Table(name = "research_paper")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResearchPaper implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id")
	private Resource resource;
	
	private String title;
	private String academicJournal;
	
	@OneToMany(mappedBy = "researchPaper")
	private Set<RprojectRpaper> rprojectRpapers;

	public ResearchPaper(Resource resource, String title, String academicJournal) {
		this.resource = resource;
		this.title = title;
		this.academicJournal = academicJournal;
	}

	public ResearchPaper(Resource resource, String title, String academicJournal, Set<RprojectRpaper> rprojectRpaperses) {
		this.resource = resource;
		this.title = title;
		this.academicJournal = academicJournal;
		this.rprojectRpapers = rprojectRpaperses;
	}

}
