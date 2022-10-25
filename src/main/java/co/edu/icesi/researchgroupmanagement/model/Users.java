package co.edu.icesi.researchgroupmanagement.model;
// Generated Oct 22, 2022, 7:53:51 PM by Hibernate Tools 5.6.7.Final

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Users implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type_id")
	private UserTypes userType;
	
	private String username;
	private String firstName;
	private String lastName;
	private Date dob;
	private String password;
	private String email;
	
	@Lob
	private byte[] userPicture;
	
	@OneToMany(mappedBy = "users")
	private Set<AdmissionRequest> admissionRequests;
	
	@OneToMany(mappedBy = "users")
	private Set<ResearchGroup> researchGroups;
	
	@OneToMany(mappedBy = "users")
	private Set<RgroupUsers> rgroupUsers;
	
	@ManyToMany
	@JoinTable(
			  name = "users_sprogram", 
			  joinColumns = @JoinColumn(name = "users_id"), 
			  inverseJoinColumns = @JoinColumn(name = "student_program_id"))
	private Set<StudentProgram> studentPrograms;
	
	@ManyToMany
	@JoinTable(
			  name = "publication_author", 
			  joinColumns = @JoinColumn(name = "users_id"), 
			  inverseJoinColumns = @JoinColumn(name = "resource_id"))
	private Set<Resource> resources;
	
	@OneToMany(mappedBy = "users")
	private Set<RprojectUsers> rprojectUsers;

	public Users() {
	}

	public Users(String username, String firstName, String lastName, Date dob, String password, String email) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.password = password;
		this.email = email;
	}

	public Users(UserTypes userType, String username, String firstName, String lastName, Date dob,
			String password, String email, byte[] userPicture, Set<AdmissionRequest> admissionRequests, Set<ResearchGroup> researchGroups,
			Set<RgroupUsers> rgroupUsers, Set<StudentProgram> studentPrograms, Set<Resource> resources, Set<RprojectUsers> rprojectUsers) {
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
		this.rprojectUsers = rprojectUsers;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserTypes getUserTypes() {
		return this.userType;
	}

	public void setUserTypes(UserTypes userTypes) {
		this.userType = userTypes;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getUserPicture() {
		return this.userPicture;
	}

	public void setUserPicture(byte[] userPicture) {
		this.userPicture = userPicture;
	}

	public Set<AdmissionRequest> getAdmissionRequests() {
		return this.admissionRequests;
	}

	public void setAdmissionRequests(Set<AdmissionRequest> admissionRequests) {
		this.admissionRequests = admissionRequests;
	}

	public Set<ResearchGroup> getResearchGroups() {
		return this.researchGroups;
	}

	public void setResearchGroups(Set<ResearchGroup> researchGroups) {
		this.researchGroups = researchGroups;
	}

	public Set<RgroupUsers> getRgroupUserses() {
		return this.rgroupUsers;
	}

	public void setRgroupUserses(Set<RgroupUsers> rgroupUserses) {
		this.rgroupUsers = rgroupUserses;
	}

	public Set<StudentProgram> getStudentPrograms() {
		return this.studentPrograms;
	}

	public void setStudentPrograms(Set<StudentProgram> studentPrograms) {
		this.studentPrograms = studentPrograms;
	}

	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<RprojectUsers> getRprojectUserses() {
		return this.rprojectUsers;
	}

	public void setRprojectUserses(Set<RprojectUsers> rprojectUserses) {
		this.rprojectUsers = rprojectUserses;
	}

}
