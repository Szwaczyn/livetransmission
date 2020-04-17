package domainmodel;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.source.doctree.SerialDataTree;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_comment", unique = true)
	private int id;

	@ManyToOne
	@JoinColumn(name = "comment_match")
	private Match match;

	@Column(name = "minute")
	private int minute;

	@Column(name = "content")
	private String content;

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
