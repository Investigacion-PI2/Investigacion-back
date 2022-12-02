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
@Table(name = "rgroup_leaders")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RgroupLeader implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@EmbeddedId
	private RgroupLeaderId id = new RgroupLeaderId();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rgroupId")
	@JoinColumn(name = "rgroup_id")
	private ResearchGroup researchGroup;
	
	private String leaderCitizenId;
	private String leaderNationality;
	private String leaderSecondLastName;
	private String leaderCountryOfBirth;

	public RgroupLeader(RgroupLeaderId id, ResearchGroup researchGroup, String leaderCitizenId,
			String leaderNationality, String leaderCountryOfBirth) {
		this.id = id;
		this.researchGroup = researchGroup;
		this.leaderCitizenId = leaderCitizenId;
		this.leaderNationality = leaderNationality;
		this.leaderCountryOfBirth = leaderCountryOfBirth;
	}

}
