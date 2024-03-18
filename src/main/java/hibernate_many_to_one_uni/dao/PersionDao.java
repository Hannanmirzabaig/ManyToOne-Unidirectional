package hibernate_many_to_one_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_one_uni.dto.Persion;

public class PersionDao {
	

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hannan");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Persion getPersionByIdDao(int id) {
		return em.find(Persion.class, id);
	}

}
