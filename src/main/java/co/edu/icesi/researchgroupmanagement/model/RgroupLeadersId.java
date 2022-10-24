package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RgroupLeadersId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "rgroup_id")
	private long rgroupId;
	@Column(name = "leader_id")
	private long leaderId;

	public RgroupLeadersId() {
	}

	public RgroupLeadersId(long rgroupId, long leaderId) {
		this.rgroupId = rgroupId;
		this.leaderId = leaderId;
	}

	public long getRgroupId() {
		return this.rgroupId;
	}

	public void setRgroupId(long rgroupId) {
		this.rgroupId = rgroupId;
	}

	public long getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(long leaderId) {
		this.leaderId = leaderId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RgroupLeadersId))
			return false;
		RgroupLeadersId castOther = (RgroupLeadersId) other;

		return (this.getRgroupId() == castOther.getRgroupId()) && (this.getLeaderId() == castOther.getLeaderId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getRgroupId();
		result = 37 * result + (int) this.getLeaderId();
		return result;
	}

}
