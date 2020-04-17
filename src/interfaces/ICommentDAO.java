package interfaces;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import domainmodel.Comment;
import domainmodel.Match;

public interface ICommentDAO {

	public boolean addComment(Comment comment);
	public List<Comment> getComment(Match match);
	public void setContext(AnnotationConfigApplicationContext context);
}
