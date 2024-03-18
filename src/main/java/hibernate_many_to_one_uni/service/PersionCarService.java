package hibernate_many_to_one_uni.service;

import java.util.List;

import hibernate_many_to_one_uni.dao.PersionCarDao;
import hibernate_many_to_one_uni.dto.Car;
import hibernate_many_to_one_uni.dto.Persion;

public class PersionCarService {
	
	PersionCarDao pcd=new PersionCarDao();
	
	/**
	 * for case 1
	 * @param c
	 * @return
	 */
	public List<Car> saveMultipleCarService(List<Car> c) {
		return pcd.saveMultipleCarDao(c);
		
	}
	
	/**
	 * for case 2
	 * @param p
	 * @return
	 */
	public Persion savePersionService(Persion p) {
		return pcd.savePersionDao(p);
	}
	
	/**
	 * for case 3
	 * @param persionId
	 * @param carId
	 * @return
	 */
	public Car associatePersionWithCarService(int persionId,int carId) {
		return pcd.associatePersionWithCarDao(persionId, carId);
	}
	
	/**
	 * for case 4
	 * @return
	 */
	public  List<Car> getAllCarAndPersionService(){
		return pcd.getAllCarAndPersionDao();
	}
	
	/**
	 * for case 5
	 * @param carId
	 * @return
	 */
	public Car deletePersonByCarIdService(int carId) {
		return pcd.deletePersonByCarIdDao(carId);
	}
	
	/**
	 * for case 6
	 * @param carId
	 * @param personName
	 * @return
	 */
	public Car updatePersonNameByCarIdDao(int carId,String personName) {
		return pcd.updatePersonNameByCarIdDao(carId, personName);
	}
	
	/**
	 * for case 7
	 */
	public List<Car> AssociateSinglePersonwithMultipleCarDao(List<Integer> integers, int personId) {
		return pcd.AssociateSinglePersonwithMultipleCarDao(integers, personId);
		
}
}
