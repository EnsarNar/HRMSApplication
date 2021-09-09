package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateSchemaAddDto {
	private int id;
	private String companyName;
	private String phoneNumber;
	private String webAdress;
	private String password;
	private String passwordRepeat;
	private String email;
	private boolean onUpdateProcess;
	private int employerId;
}
