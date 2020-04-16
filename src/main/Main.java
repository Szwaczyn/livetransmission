package main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import interfaces.IDatabase;
import utils.DBConfig;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		IDatabase db = (IDatabase)context.getBean(DBConfig.class);
		
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		System.out.println(s);
	}

}
