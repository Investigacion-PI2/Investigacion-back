package co.edu.icesi.researchgroupmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admission_request")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRequest implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private AdmissionStatus admissionStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ResearchGroup researchGroup;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	private String description;
	private Date startDate;
	private Date finishDate;

	public AdmissionRequest(long id, Date startDate) {
		this.id = id;
		this.startDate = startDate;
	}

}
