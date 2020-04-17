package match.execution;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import domainmodel.Match;
import interfaces.IMatchExecution;

@Component
@Primary
public class ExecutionManager implements IMatchExecution {

	private static int exitCode = 5;

	private Match match;
	private AnnotationConfigApplicationContext context;
	
	@Override
	public void beginMatch() {
		System.out.println(context != null);
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
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	private void showComment(Match match) {
		
	}

	public AnnotationConfigApplicationContext getContext() {
		return context;
	}

	public void setContext(AnnotationConfigApplicationContext context) {
		this.context = context;
	}

	
}
