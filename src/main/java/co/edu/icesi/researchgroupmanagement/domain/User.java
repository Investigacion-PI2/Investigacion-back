package co.edu.icesi.researchgroupmanagement.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
	@SequenceGenerator(name = "USER_TYPE_GENERATOR", allocationSize = 1, sequenceName = "USER_TYPE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_TYPE_GENERATOR")
	private Long id;

    private String username;
    private String password;
    private Long type;
}
