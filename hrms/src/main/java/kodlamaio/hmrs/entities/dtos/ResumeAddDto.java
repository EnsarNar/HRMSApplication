package kodlamaio.hmrs.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAddDto {	
	private int id; //Resum'un idsi. Buranın özel idsi deil
	//private String profilePictureUrl;
	private int candidateId;

	
}
