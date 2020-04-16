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

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(utils.Configuration.class);
		ITeam teamDAO = (ITeam)context.getBean(TeamDAO.class);
		
		Scanner in = new Scanner(System.in);
		String newNameTeam = in.nextLine();
		
		Team newTeam = new Team();
		newTeam.setName(newNameTeam);
		
		teamDAO.newTeam(newTeam);
		
		in.close();
	}

}
