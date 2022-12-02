package co.edu.icesi.researchgroupmanagement.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
//@Table(name = "rgroup_leaders_id")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RgroupLeaderId implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Column(name = "rgroup_id")
	private Long rgroupId;
	@Column(name = "leader_id")
	private Long leaderId;

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RgroupLeaderId))
			return false;
		RgroupLeaderId castOther = (RgroupLeaderId) other;

		return (this.getRgroupId() == castOther.getRgroupId()) && (this.getLeaderId() == castOther.getLeaderId());
	}

}
