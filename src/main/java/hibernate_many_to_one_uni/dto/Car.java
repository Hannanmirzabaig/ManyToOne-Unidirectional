package hibernate_many_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	@Id
	private int id;
	private String name;
	private String color;
	private double price;
	private String type;

	@ManyToOne
	private Persion persion;

	public Car(int id, String name, String color, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.type = type;
	}
	
}


