package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RgroupUsersId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "research_group_id")
	private long researchGroupId;
	@Column(name = "users_id")
	private long usersId;

	public RgroupUsersId() {
	}

	public RgroupUsersId(long researchGroupId, long usersId) {
		this.researchGroupId = researchGroupId;
		this.usersId = usersId;
	}

	public long getResearchGroupId() {
		return this.researchGroupId;
	}

	public void setResearchGroupId(long researchGroupId) {
		this.researchGroupId = researchGroupId;
	}

	public long getUsersId() {
		return this.usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RgroupUsersId))
			return false;
		RgroupUsersId castOther = (RgroupUsersId) other;

		return (this.getResearchGroupId() == castOther.getResearchGroupId())
				&& (this.getUsersId() == castOther.getUsersId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getResearchGroupId();
		result = 37 * result + (int) this.getUsersId();
		return result;
	}

}
