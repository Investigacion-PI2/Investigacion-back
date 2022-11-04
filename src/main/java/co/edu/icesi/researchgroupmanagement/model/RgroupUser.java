package co.edu.icesi.researchgroupmanagement.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rgroup_users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RgroupUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@GeneratedValue(strategy= GenerationType.AUTO)
	private RgroupUserId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("researchGroupId")
	@JoinColumn(name = "research_project_id")
	private ResearchGroup researchGroup;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
	@JoinColumn(name = "users_id")
	private User user;
	
	private Date userEntry;
	private Date userExit;

	public RgroupUser(RgroupUserId id, ResearchGroup researchGroup, User user, Date userEntry) {
		this.id = id;
		this.researchGroup = researchGroup;
		this.user = user;
		this.userEntry = userEntry;
	}

}
