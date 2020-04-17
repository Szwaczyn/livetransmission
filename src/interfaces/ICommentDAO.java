package interfaces;

import java.util.List;

import domainmodel.Comment;
import domainmodel.Match;

public interface ICommentDAO {

	public boolean addComment(Comment comment);
	public List<Comment> getComment(Match match);
}
