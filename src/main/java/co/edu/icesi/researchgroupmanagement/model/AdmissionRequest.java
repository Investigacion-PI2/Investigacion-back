package co.edu.icesi.researchgroupmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private static final Long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "ADMISSIONSREQUEST_ID_GENERATOR", allocationSize = 1, sequenceName = "ADMISSION_REQUEST_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMISSIONSREQUEST_ID_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id")
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "admissionRequests"}, allowSetters = true)
	private AdmissionStatus admissionStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true)
	private ResearchProject researchProject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true)
	private User user;
	
	private String description;
	private Date startDate;
	private Date finishDate;

	public AdmissionRequest(Long id, Date startDate) {
		this.id = id;
		this.startDate = startDate;
	}

}
