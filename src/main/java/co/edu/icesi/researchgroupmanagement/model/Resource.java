package co.edu.icesi.researchgroupmanagement.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resource")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Resource implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RESOURCE_ID_GENERATOR", allocationSize = 1, sequenceName = "RESOURCE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESOURCE_ID_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_project_id")
	private ResearchProject researchProject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_visibility_id")
	private ResourceVisibility resourceVisibility;
	
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
	private Set<User> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "research_paper_id")
	private ResearchPaper researchPaper;

	public Resource(Long id, String description, Date publishDate, String resourceUrl) {
		this.id = id;
		this.description = description;
		this.publishDate = publishDate;
		this.resourceUrl = resourceUrl;
	}

}
