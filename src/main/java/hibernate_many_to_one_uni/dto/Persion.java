package hibernate_many_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persion {
	
	@Id
	private int id;
	private String name;
	private int age;
	private String email;

}
