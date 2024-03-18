package hibernate_many_to_one_uni.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hibernate_many_to_one_uni.dao.PersionCarDao;
import hibernate_many_to_one_uni.dto.Car;
import hibernate_many_to_one_uni.dto.Persion;
import hibernate_many_to_one_uni.service.PersionCarService;

public class PersionCarController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersionCarService pcs = new PersionCarService();

		while (true) {
			System.out.println("1-INSERT car\n2-insert persion\n3-associate\n4-get all car and person details \n5-delete person by car id");
			System.out.println("6-update persion name by car id \n7-associate sinle person with multiple car");
			int n = sc.nextInt();
			
			switch (n) {

			case 1: {

				Car car1 = new Car(800, "audi", "Grey", 1234543.543, "diesel");
				Car car2 = new Car(900, "Range Rover", "Red", 4234543.543, "electric");
				Car car3 = new Car(1000, "nano", "Grey", 1234543.543, "diesel");

				List<Car> l = Arrays.asList(car1, car2,car3);

				List<Car> c = pcs.saveMultipleCarService(l);
				if (c != null) {
					System.out.println("successfully car insert ");

				} else {
					System.out.println("not save");
				}

			}
				break;
			case 2: {
				Persion p = new Persion(103, "abdul", 24, "abdul@gmail.com");
				pcs.savePersionService(p);
			}
			case 3: {
				pcs.associatePersionWithCarService(101, 500);
			}
				break;

			case 4: {
				List<Car> c=pcs.getAllCarAndPersionService();
				if(c!=null) {
					System.out.println("Car detail");
					for (Car car : c) {
						System.out.println(c);
						
						Persion p=car.getPersion();
						if(p!=null) {
							
						System.out.println(p);
							
						}
						
						
					}
					
				}else {
					System.out.println("data not found plz check code");
				}

			}
				break;

			case 5: {
				System.out.println("enter the car id");
				int id = sc.nextInt();
				Car c = pcs.deletePersonByCarIdService(id);
				if (c != null) {
					System.out.println("successfully deleted");
				} else {
					System.out.println("id does not found");
				}

			}
				break;
			case 6:{
				System.out.println("enter the car id");
				int id=sc.nextInt();
				System.out.println("enter the person new name");
				String name=sc.next();
				
				Car c=pcs.updatePersonNameByCarIdDao(id, name);
				if(c!=null) {
					System.out.println("successfully person name updated");
				}else {
					System.out.println("id does not found ");
				}
			}break;
			
			case 7:{
				
				List<Integer> integers=Arrays.asList(800,900,1000);
				List<Car> car=pcs.AssociateSinglePersonwithMultipleCarDao(integers, 103);
				
				if(car!=null) {
					System.out.println("successfully associate");
				}else {
					System.out.println("data does not associate");
				}
				
			}break;
			default: {
				System.out.println("plz choose valid option");
			}
			}

		}
	}

}
