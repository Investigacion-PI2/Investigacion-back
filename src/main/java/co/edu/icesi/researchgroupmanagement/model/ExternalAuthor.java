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
@Table(name = "external_author")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExternalAuthor implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EXTERNALAUTHOR_ID_GENERATOR", allocationSize = 1, sequenceName = "EXTERNAL_AUTHOR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXTERNALAUTHOR_ID_GENERATOR")
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "externalAuthors")
	private Set<Resource> resources;

	public ExternalAuthor(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
