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

	@ManyToOne
	@JoinColumn(name = "home_team")
	private Team homeTeam;

	@ManyToOne
	@JoinColumn(name = "away_team")
	private Team awayTeam;

	@Column(name = "started")
	private boolean started;

	@Column(name = "finished")
	private boolean finished;

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

	public Team getHome_team() {
		return homeTeam;
	}

	public void setHome_team(Team home_team) {
		this.homeTeam = home_team;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
