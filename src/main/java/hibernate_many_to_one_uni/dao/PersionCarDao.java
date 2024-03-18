package hibernate_many_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_one_uni.dto.Car;
import hibernate_many_to_one_uni.dto.Persion;

public class PersionCarDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hannan");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public List<Car> saveMultipleCarDao(List<Car> c) {

		et.begin();
		for (Car car : c) {
			em.persist(car);
		}

		et.commit();
		return c;

	}

	public Persion savePersionDao(Persion p) {
		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Car associatePersionWithCarDao(int persionId, int carId) {
		Car c = em.find(Car.class, carId);
		Persion p = em.find(Persion.class, persionId);
		if ((c != null) && (p != null)) {

			c.setPersion(p);
			et.begin();

			em.merge(c);
			et.commit();
			return c;
		} else {
			return null;
		}
		 
	}

	/**
	 * for case 4 method declaration
	 */
	public List<Car> getAllCarAndPersionDao() {
		String query = " from Car";
		List<Car> c = em.createQuery(query).getResultList();
		return c;

	}

	/**
	 * for case 5
	 * 
	 * @param carId
	 * @return
	 */
	public Car deletePersonByCarIdDao(int carId) {
		Car c = em.find(Car.class, carId);
		if (c != null) {
			Persion p = c.getPersion();

			et.begin();
			em.remove(p);
			et.commit();
			return c;

		}
		return null;

	}

	/**
	 * for case 6
	 */
	public Car updatePersonNameByCarIdDao(int carId, String personName) {
		Car c = em.find(Car.class, carId);
		if (c != null) {
			Persion p = c.getPersion();
			p.setName(personName);
			et.begin();
			em.merge(p);
			et.commit();
			return c;

		}
		return null;
	}

	/**
	 * this is object of CarDao and PersionDao object
	 */
	CarDao carDao = new CarDao();
	PersionDao persionDao = new PersionDao();

	public List<Car> AssociateSinglePersonwithMultipleCarDao(List<Integer> integers, int personId) {

		Persion persion = persionDao.getPersionByIdDao(personId);
		List<Car> cars = carDao.getAllCarDataDao();
		if (persion != null) {
			for (Car car : cars) {

				for (Integer integer : integers) {
					if (car.getId() == integer) {
						car.setPersion(persion);
						et.begin();
						em.merge(car);
						et.commit();
					}

				}

			}

		}

		return cars;

	}

}
