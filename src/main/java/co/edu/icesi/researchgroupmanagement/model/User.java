package co.edu.icesi.researchgroupmanagement.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_ID_GENERATOR", allocationSize = 1, sequenceName = "USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_types_id")
    @JsonIgnore
	private UserType userType;
	
	private String username;
	private String firstName;
	private String lastName;
	private Date dob;
	private String password;
	private String email;
	
	@Lob
	private byte[] userPicture;
	
	@OneToMany(mappedBy = "user")
	private Set<AdmissionRequest> admissionRequests;
	
	@OneToMany(mappedBy = "user")
	private Set<ResearchGroup> researchGroups;
	
	@OneToMany(mappedBy = "user")
	private Set<RgroupUser> rgroupUsers;
	
	@ManyToMany
	@JoinTable(
			  name = "user_sprogram", 
			  joinColumns = @JoinColumn(name = "users_id"), 
			  inverseJoinColumns = @JoinColumn(name = "student_program_id"))
	private Set<StudentProgram> studentPrograms;
	
	@ManyToMany
	@JoinTable(
			  name = "publication_author", 
			  joinColumns = @JoinColumn(name = "users_id"), 
			  inverseJoinColumns = @JoinColumn(name = "resource_id"))
	private Set<Resource> resources;
	
	@OneToMany(mappedBy = "user")
	private Set<RprojectUser> rRprojectUser;

	public User(String username, String firstName, String lastName, Date dob, String password, String email) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.password = password;
		this.email = email;
	}

	public User(UserType userType, String username, String firstName, String lastName, Date dob,
			String password, String email, byte[] userPicture, Set<AdmissionRequest> admissionRequests, Set<ResearchGroup> researchGroups,
			Set<RgroupUser> rgroupUsers, Set<StudentProgram> studentPrograms, Set<Resource> resources, Set<RprojectUser> rRprojectUser) {
		this.userType = userType;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.password = password;
		this.email = email;
		this.userPicture = userPicture;
		this.admissionRequests = admissionRequests;
		this.researchGroups = researchGroups;
		this.rgroupUsers = rgroupUsers;
		this.studentPrograms = studentPrograms;
		this.resources = resources;
		this.rRprojectUser = rRprojectUser;
	}

}
