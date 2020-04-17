package match.execution;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import dao.CommentDAO;
import domainmodel.Comment;
import domainmodel.Match;
import interfaces.IMatchExecution;

@Component
@Primary
public class ExecutionManager implements IMatchExecution {

	private static int exitCode = 0;

	private Match match;
	private AnnotationConfigApplicationContext context;
	
	@Override
	public void beginMatch() {

		if (this.match != null) {
			this.match.setStarted(true);
			matchManager();
		} else {
			System.out.println("Brak meczu do rozpoczêcia");
		}
	}

	private void matchManager() {
		Scanner in = new Scanner(System.in);
		int action = 0;
		;

		do {
			try {

				showMenu();
				action = Integer.parseInt(in.nextLine());

				switch (action) {

				case 1: {
					showComment();
					
					CommentDAO commentDAO = context.getBean(CommentDAO.class);
					int code = exitCode - 100000;
					String content;
					do {
						content = in.nextLine();
						
						try {
						 	code = Integer.parseInt(content);
						}catch(Exception e) {}
						
						if(code != exitCode && content != null) {
							Comment comment = new Comment();
							comment.setMatch(this.match);
							comment.setContent(content);
							
							commentDAO.addComment(comment);
						}
					} while (code != exitCode);
				}
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
				action = 0;
			}
		} while (action != exitCode);
	}

	private void showMenu() {
		System.out.println("1. Tryb komentowania");
		System.out.println(exitCode + ". Tryb komentowania");
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	private void showComment() {
		CommentDAO commentDAO = context.getBean(CommentDAO.class);
		List<Comment> comments = commentDAO.getComment(match);
		
		for(Comment c : comments) {
			System.out.println(c.getMinute() + ". " + c.getContent());
		}
	}

	public void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}

	
}
