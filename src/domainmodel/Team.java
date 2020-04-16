package domainmodel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_team", unique = true)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name = "home_team")
	private List<Match> matches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}
