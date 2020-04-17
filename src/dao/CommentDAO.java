package dao;

import java.util.List;

import javax.persistence.EntityManager;

import domainmodel.Comment;
import domainmodel.Match;
import interfaces.ICommentDAO;

public class CommentDAO implements ICommentDAO {

	private EntityManager em;
	
	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comment> getComment(Match match) {
		// TODO Auto-generated method stub
		return null;
	}

}
