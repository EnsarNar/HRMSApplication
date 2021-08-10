package kodlamaio.hmrs.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAddDto {	
	private int id; //Resum'un idsi. Buranın deil
	//private String profilePictureUrl;
	private int candidateId;

	
}
