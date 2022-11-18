package co.edu.icesi.researchgroupmanagement.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_program")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentProgram implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "STUDENT_PROGRAM_ID_GENERATOR", allocationSize = 1, sequenceName = "STUDENT_PROGRAM_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_PROGRAM_ID_GENERATOR")
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "studentPrograms")
	private Set<User> users;

	public StudentProgram(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
