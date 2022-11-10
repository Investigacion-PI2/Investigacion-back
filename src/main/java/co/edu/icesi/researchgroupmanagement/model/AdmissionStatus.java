package co.edu.icesi.researchgroupmanagement.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String status;
	
	@OneToMany(mappedBy = "admissionStatus")
	private Set<AdmissionRequest> admissionRequests;

	public AdmissionStatus(long id, String status) {
		this.id = id;
		this.status = status;
	}

}
