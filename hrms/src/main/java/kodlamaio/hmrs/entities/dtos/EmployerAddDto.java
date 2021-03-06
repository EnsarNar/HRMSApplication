package kodlamaio.hmrs.entities.dtos;

import kodlamaio.hmrs.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerAddDto {
	private int id;
	private String password;
	private String password_repeat;
	private String email;
	private String companyName;
	private String phoneNumber;
	private String webAdress;
	private Employer updatedData;
}
