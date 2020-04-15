package domainmodel;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "matchday")
public class Match implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_team", unique = true)
	private int id;

	@Column(name = "score_home")
	private int scoreHome;

	@Column(name = "score_away")
	private int scoreAway;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScoreHome() {
		return scoreHome;
	}

	public void setScoreHome(int scoreHome) {
		this.scoreHome = scoreHome;
	}

	public int getScoreAway() {
		return scoreAway;
	}

	public void setScoreAway(int scoreAway) {
		this.scoreAway = scoreAway;
	}
	
	
}
