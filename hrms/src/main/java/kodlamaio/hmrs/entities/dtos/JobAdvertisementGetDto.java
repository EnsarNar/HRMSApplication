package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementGetDto {
	
	private int JobAdvertisementId;
	private String jobPositionJobPosition;
	private String employerCompanyName;
	private String cityCityName;
	private LocalDate applicationDeadline;
	private String defination;
	private String salary;
	private int numberOfOpenPositions;

	
	
}
