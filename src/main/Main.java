package main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("livetransmission");
		EntityManager em = emf.createEntityManager();
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		System.out.println(s);
	}

}
