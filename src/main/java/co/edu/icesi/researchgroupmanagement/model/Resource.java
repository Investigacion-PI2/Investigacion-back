package co.edu.icesi.researchgroupmanagement.model;

// Generated Oct 15, 2022, 11:56:22 PM by Hibernate Tools 5.6.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Resource generated by hbm2java
 */
public class Resource implements java.io.Serializable {

	private long id;
	private ResearchProject researchProject;
	private ResourceVisibilities resourceVisibilities;
	private String description;
	private Date publishDate;
	private String resourceUrl;
	private Set externalAuthors = new HashSet(0);
	private Set userses = new HashSet(0);
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
			String description, Date publishDate, String resourceUrl, Set externalAuthors, Set userses,
			ResearchPaper researchPaper) {
		this.id = id;
		this.researchProject = researchProject;
		this.resourceVisibilities = resourceVisibilities;
		this.description = description;
		this.publishDate = publishDate;
		this.resourceUrl = resourceUrl;
		this.externalAuthors = externalAuthors;
		this.userses = userses;
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

	public Set getExternalAuthors() {
		return this.externalAuthors;
	}

	public void setExternalAuthors(Set externalAuthors) {
		this.externalAuthors = externalAuthors;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

	public ResearchPaper getResearchPaper() {
		return this.researchPaper;
	}

	public void setResearchPaper(ResearchPaper researchPaper) {
		this.researchPaper = researchPaper;
	}

}
