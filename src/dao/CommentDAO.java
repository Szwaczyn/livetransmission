package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Component;

import domainmodel.Comment;
import domainmodel.Match;
import interfaces.ICommentDAO;
import interfaces.IDatabase;

@Component
public class CommentDAO implements ICommentDAO {

	private EntityManager em;

	public CommentDAO(IDatabase db) {
		this.em = db.getEntityManager();
	}

	@Override
	public boolean addComment(Comment comment) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			em.persist(comment);
			et.commit();
			return true;
		} catch (Exception e) {
			et.rollback();
			return false;
		}
	}

	@Override
	public List<Comment> getComment(Match match) {
		List<Comment> comments = em.createQuery("SELECT c FROM Comment c WHERE match = :match")
				.setParameter("match", match)
				.getResultList();
		
		return comments;
	}

}
