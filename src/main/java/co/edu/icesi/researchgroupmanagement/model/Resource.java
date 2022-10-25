package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Resource generated by hbm2java
 */
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Resource implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_project_id")
	private ResearchProject researchProject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_visibility_id")
	private ResourceVisibilities resourceVisibilities;
	
	private String description;
	private Date publishDate;
	private String resourceUrl;
	
	@ManyToMany
	@JoinTable(
			  name = "publication_eauthor", 
			  joinColumns = @JoinColumn(name = "resource_id"), 
			  inverseJoinColumns = @JoinColumn(name = "external_author_id"))
	private Set<ExternalAuthor> externalAuthors;
	
	@ManyToMany(mappedBy = "resources")
	private Set<Users> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_paper_id")
	private ResearchPaper researchPaper;

	public Resource() {
	}

	public Resource(long id, String description, Date publishDate, String resourceUrl) {
		this.id = id;
		this.description = description;
		this.publishDate = publishDate;
		this.resourceUrl = resourceUrl;
	}

	public Resource(long id, ResearchProject researchProject, ResourceVisibilities resourceVisibilities,
			String description, Date publishDate, String resourceUrl, Set<ExternalAuthor> externalAuthors, Set<Users> users,
			ResearchPaper researchPaper) {
		this.id = id;
		this.researchProject = researchProject;
		this.resourceVisibilities = resourceVisibilities;
		this.description = description;
		this.publishDate = publishDate;
		this.resourceUrl = resourceUrl;
		this.externalAuthors = externalAuthors;
		this.users = users;
		this.researchPaper = researchPaper;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ResearchProject getResearchProject() {
		return this.researchProject;
	}

	public void setResearchProject(ResearchProject researchProject) {
		this.researchProject = researchProject;
	}

	public ResourceVisibilities getResourceVisibilities() {
		return this.resourceVisibilities;
	}

	public void setResourceVisibilities(ResourceVisibilities resourceVisibilities) {
		this.resourceVisibilities = resourceVisibilities;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getResourceUrl() {
		return this.resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public Set<ExternalAuthor> getExternalAuthors() {
		return this.externalAuthors;
	}

	public void setExternalAuthors(Set<ExternalAuthor> externalAuthors) {
		this.externalAuthors = externalAuthors;
	}

	public Set<Users> getUserses() {
		return this.users;
	}

	public void setUserses(Set<Users> userses) {
		this.users = userses;
	}

	public ResearchPaper getResearchPaper() {
		return this.researchPaper;
	}

	public void setResearchPaper(ResearchPaper researchPaper) {
		this.researchPaper = researchPaper;
	}

}
