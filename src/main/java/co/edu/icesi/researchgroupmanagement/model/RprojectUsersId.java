package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RprojectUsersId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "research_project_id")
	private long researchProjectId;
	@Column(name = "users_id")
	private long usersId;

	public RprojectUsersId() {
	}

	public RprojectUsersId(long researchProjectId, long usersId) {
		this.researchProjectId = researchProjectId;
		this.usersId = usersId;
	}

	public long getResearchProjectId() {
		return this.researchProjectId;
	}

	public void setResearchProjectId(long researchProjectId) {
		this.researchProjectId = researchProjectId;
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
		if (!(other instanceof RprojectUsersId))
			return false;
		RprojectUsersId castOther = (RprojectUsersId) other;

		return (this.getResearchProjectId() == castOther.getResearchProjectId())
				&& (this.getUsersId() == castOther.getUsersId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getResearchProjectId();
		result = 37 * result + (int) this.getUsersId();
		return result;
	}

}
