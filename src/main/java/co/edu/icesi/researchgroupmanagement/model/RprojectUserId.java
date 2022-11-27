package co.edu.icesi.researchgroupmanagement.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
//@Table(name = "RRprojectUserId")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RprojectUserId implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Column(name = "research_project_id")
	private Long researchProjectId;
	@Column(name = "users_id")
	private Long userId;
	

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RprojectUserId))
			return false;
		RprojectUserId castOther = (RprojectUserId) other;

		return (this.getResearchProjectId() == castOther.getResearchProjectId())
				&& (this.getUserId() == castOther.getUserId());
	}

}
