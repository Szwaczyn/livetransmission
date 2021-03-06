package main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.MatchDAO;
import dao.TeamDAO;
import domainmodel.Match;
import domainmodel.Team;
import interfaces.IMatchDAO;
import interfaces.IMatchExecution;
import interfaces.ITeamDAO;
import match.execution.ExecutionManager;
import utils.Status;

public class Main {

	private static int exitCode = 0;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(utils.Configuration.class);
		ITeamDAO teamDAO = (ITeamDAO) context.getBean(TeamDAO.class);
		IMatchDAO matchDAO = (IMatchDAO) context.getBean(MatchDAO.class);
		IMatchExecution execman = (IMatchExecution) context.getBean(ExecutionManager.class);
		execman.setContext(context);

		Scanner in = new Scanner(System.in);
		int action;
		do {
			showMenu();

			try {
				action = Integer.parseInt(in.nextLine());
				if (action != exitCode) {
					switch (action) {

					case 1: {
						System.out.println("Podaj nazw� dru�yny: ");
						String newNameOfTeam = in.nextLine();

						Team newTeam = new Team();
						newTeam.setName(newNameOfTeam);
						teamDAO.newTeam(newTeam);

						System.out.println("\nUtworzono now� dru�yn� o nazwie " + newTeam.getName() + ".");
					}
						break;

					case 2: {
						List<Match> matches = matchDAO.getMatch(Status.notStarted);

						int iterator = 1;

						System.out.println("");
						for (Match m : matches) {
							System.out.println(m.getHomeTeam().getName() + " - " + m.getAwayTeam().getName());
							iterator++;
						}
						System.out.println("");
					}
						break;

					case 3: {
						List<Team> teams = teamDAO.getTeam();
						int iterator = 1;

						System.out.println("Gospodarze:");
						for (Team t : teams) {
							System.out.println(iterator + ". " + t.getName());
							iterator++;
						}
						System.out.println("");

						Team homeTeam = teams.get(Integer.parseInt(in.nextLine()) - 1);
						iterator = 1;
						teams.remove(homeTeam);

						System.out.println("Go�cie:");
						for (Team t : teams) {
							System.out.println(iterator + ". " + t.getName());
							iterator++;
						}
						System.out.println("");

						Team awayTeam = teams.get(Integer.parseInt(in.nextLine()) - 1);

						Match match = matchDAO.newMatch(homeTeam, awayTeam);
					}
						break;

					case 4: {
						List<Match> matches = matchDAO.getMatch(Status.notStarted);

						int iterator = 1;

						System.out.println("");
						for (Match m : matches) {
							System.out.println(
									iterator + ". " + m.getHomeTeam().getName() + " - " + m.getAwayTeam().getName());
							iterator++;
						}
						System.out.println("");

						execman.setMatch(matches.get(Integer.parseInt(in.nextLine()) - 1));
						execman.beginMatch();
					}
						break;
					case 5: {
						List<Match> matches = matchDAO.getMatch(Status.Finished);
						
						int iterator = 1;

						System.out.println("");
						for (Match m : matches) {
							System.out.println(m.getHomeTeam().getName() +" " + m.getScoreHome() + ":" + m.getScoreAway() + " " + m.getAwayTeam().getName());
							iterator++;
						}
						System.out.println("");
					}
						break;
					}
				}
			} catch (Exception e) {
				action = 0;
				e.printStackTrace();
				System.out.println("Podaj prawid�ow� warto��");
			}

		} while (action != exitCode);

		in.close();
		context.close();
	}

	public static void showMenu() {
		System.out.println("1. Dodaj dru�yne");
		System.out.println("2. Poka� zaplanowane mecze");
		System.out.println("3. Zaplanuj mecz");
		System.out.println("4. Rozpocznij mecz");
		System.out.println("5. Poka� rozegrane mecze");
		System.out.println(exitCode + ". Wyj�cie");
	}
}
