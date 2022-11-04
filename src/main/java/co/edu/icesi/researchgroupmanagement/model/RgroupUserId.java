package co.edu.icesi.researchgroupmanagement.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
//@Table(name = "RgroupUsersId")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RgroupUserId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "research_group_id")
	private long researchGroupId;
	@Column(name = "users_id")
	private long userId;

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RgroupUserId))
			return false;
		RgroupUserId castOther = (RgroupUserId) other;

		return (this.getResearchGroupId() == castOther.getResearchGroupId())
				&& (this.getUserId() == castOther.getUserId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getResearchGroupId();
		result = 37 * result + (int) this.getUserId();
		return result;
	}

}
