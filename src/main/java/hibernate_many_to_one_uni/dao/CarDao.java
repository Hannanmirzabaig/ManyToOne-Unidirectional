package hibernate_many_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_one_uni.dto.Car;
import hibernate_many_to_one_uni.dto.Persion;


public class CarDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hannan");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public List<Car> getAllCarDataDao(){
		return em.createQuery("from Car").getResultList();
	}
	
	
	
	

}
