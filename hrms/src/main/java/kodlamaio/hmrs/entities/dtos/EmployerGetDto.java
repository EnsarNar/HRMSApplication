package kodlamaio.hmrs.entities.dtos;

import java.util.List;

import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerGetDto {
	private int id;
	private String password;
	private String password_repeat;
	private String email;
	private String companyName;
	private String phoneNumber;
	private String webAdress;
	private List<JobAdvertisement> jobAdvertisements;

	


			
	//private JSONObject updatedData;
}
