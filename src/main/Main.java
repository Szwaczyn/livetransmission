package main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import dao.TeamDAO;
import domainmodel.Team;
import interfaces.IDatabase;
import interfaces.ITeam;
import utils.DBConfig;

public class Main {

	private static int exitCode = 2;
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(utils.Configuration.class);
		ITeam teamDAO = (ITeam)context.getBean(TeamDAO.class);
		
		Scanner in = new Scanner(System.in);
		int action;
		do {
		showMenu();
		
		try {
			action = Integer.parseInt(in.nextLine());
			if(action != exitCode) {
				switch(action) {
				
					case 1:{
						System.out.println("Podaj nazwê dru¿yny: ");
						String newNameOfTeam = in.nextLine();
						
						Team newTeam = new Team();
						newTeam.setName(newNameOfTeam);
						teamDAO.newTeam(newTeam);
						
						System.out.println("\nUtworzono now¹ dru¿ynê o nazwie " + newTeam.getName() + ".");
					}break;
				
				}
			}
		}catch(Exception e) {
			action = 0;
			System.out.println("Podaj prawid³ow¹ wartoœæ");
		}
		
		} while (action != exitCode);

		in.close();
		context.close();
	}
	
	public static void showMenu() {
		System.out.println("1. Dodaj dru¿yne");
		System.out.println("2. Wyjœcie");
	}
}
