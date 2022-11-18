package co.edu.icesi.researchgroupmanagement.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rproject_rpapers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RprojectRpaper implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@EmbeddedId
	private RprojectRpaperId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("researchPaperId")
	@JoinColumn(name = "research_paper_id")
	private ResearchPaper researchPaper;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("researchProjectId")
	@JoinColumn(name = "research_project_id")
	private ResearchProject researchProject;
	
	private byte[] isProjectMember;

}
