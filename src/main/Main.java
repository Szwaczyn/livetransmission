package main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import dao.TeamDAO;
import interfaces.IDatabase;
import interfaces.ITeam;
import utils.DBConfig;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(utils.Configuration.class);
		ITeam team = (ITeam)context.getBean(TeamDAO.class);
		
		System.out.println(team.newTeam("ok"));
		
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(s);
		in.close();
	}

}
