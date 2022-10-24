package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RprojectRpapersId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "research_project_id")
	private long researchProjectId;
	@Column(name = "research_paper_id")
	private long researchPaperId;

	public RprojectRpapersId() {
	}

	public RprojectRpapersId(long researchProjectId, long researchPaperId) {
		this.researchProjectId = researchProjectId;
		this.researchPaperId = researchPaperId;
	}

	public long getResearchProjectId() {
		return this.researchProjectId;
	}

	public void setResearchProjectId(long researchProjectId) {
		this.researchProjectId = researchProjectId;
	}

	public long getResearchPaperId() {
		return this.researchPaperId;
	}

	public void setResearchPaperId(long researchPaperId) {
		this.researchPaperId = researchPaperId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RprojectRpapersId))
			return false;
		RprojectRpapersId castOther = (RprojectRpapersId) other;

		return (this.getResearchProjectId() == castOther.getResearchProjectId())
				&& (this.getResearchPaperId() == castOther.getResearchPaperId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getResearchProjectId();
		result = 37 * result + (int) this.getResearchPaperId();
		return result;
	}

}
