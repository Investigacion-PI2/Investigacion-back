package co.edu.icesi.researchgroupmanagement.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "admission_status")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionStatus implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "ADMISSIONSTATUS_ID_GENERATOR", allocationSize = 1, sequenceName = "ADMISSION_STATUS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMISSIONSTATUS_ID_GENERATOR")
	private Long id;
	
	private String status;
	
	@OneToMany(mappedBy = "admissionStatus")
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "admissionStatus", "researchProject"}, allowSetters = true)
	private Set<AdmissionRequest> admissionRequests;

	public AdmissionStatus(Long id, String status) {
		this.id = id;
		this.status = status;
	}

}
