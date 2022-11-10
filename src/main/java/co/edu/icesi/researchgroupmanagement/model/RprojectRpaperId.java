package co.edu.icesi.researchgroupmanagement.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
//@Table(name = "RprojectRpapersId")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RprojectRpaperId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "research_project_id")
	private long researchProjectId;
	@Column(name = "research_paper_id")
	private long researchPaperId;

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RprojectRpaperId))
			return false;
		RprojectRpaperId castOther = (RprojectRpaperId) other;

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
