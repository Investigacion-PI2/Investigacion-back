// default package
// Generated Oct 15, 2022, 11:56:22 PM by Hibernate Tools 5.6.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * ResearchArea generated by hbm2java
 */
public class ResearchArea implements java.io.Serializable {

	private long id;
	private GreatRarea greatRarea;
	private String name;
	private String description;
	private Set researchLines = new HashSet(0);

	public ResearchArea() {
	}

	public ResearchArea(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public ResearchArea(long id, GreatRarea greatRarea, String name, String description, Set researchLines) {
		this.id = id;
		this.greatRarea = greatRarea;
		this.name = name;
		this.description = description;
		this.researchLines = researchLines;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GreatRarea getGreatRarea() {
		return this.greatRarea;
	}

	public void setGreatRarea(GreatRarea greatRarea) {
		this.greatRarea = greatRarea;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getResearchLines() {
		return this.researchLines;
	}

	public void setResearchLines(Set researchLines) {
		this.researchLines = researchLines;
	}

}
