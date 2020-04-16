package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import interfaces.IDatabase;

@Component
public class DBConfig implements IDatabase{

	private String name;
	
	public DBConfig(@Value("livetransmission") String configuration_name) {
		super();
		this.name = configuration_name;
	}
	
	@Override
	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(name);
		EntityManager em = emf.createEntityManager();
		
		return em;
	}

}
