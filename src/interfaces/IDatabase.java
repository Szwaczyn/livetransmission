package interfaces;

import javax.persistence.EntityManager;

public interface IDatabase {

	public EntityManager getEntityManager();
}
