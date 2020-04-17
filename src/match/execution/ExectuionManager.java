package match.execution;

import java.util.Scanner;

import domainmodel.Match;
import interfaces.IMatchExecution;

public class ExectuionManager implements IMatchExecution {

	private static int exitCode = 5;

	private Match match;

	public ExectuionManager(Match match) {
		this.match = match;
	}

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

}
