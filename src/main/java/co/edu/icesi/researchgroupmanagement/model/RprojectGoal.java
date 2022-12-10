package co.edu.icesi.researchgroupmanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rproject_goal")
@Setter
@Getter
@NoArgsConstructor
public class RprojectGoal implements java.io.Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RPROJECT_GOAL_ID_GENERATOR", allocationSize = 1, sequenceName = "RPROJECT_GOAL_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RPROJECT_GOAL_ID_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "research_project_id")
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "rprojectGoals"}, allowSetters = true)
	private ResearchProject researchProject;
	
	@Override
	public String toString() {
		return "RprojectGoal [id=" + id + ", researchProject=" + researchProject + ", description=" + description
				+ ", isFinished=" + isFinished + "]";
	}
	private String description;
	private char isFinished;

	@JsonCreator
	public RprojectGoal(Long id, ResearchProject researchProject, String description, char isFinished) {
		super();
		this.id = id;
		this.researchProject = researchProject;
		this.description = description;
		this.isFinished = isFinished;
	}

}
