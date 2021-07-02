package kodlamaio.hmrs.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployersSelectDto {

	private int key;
	private int value;
	private String text;
}
