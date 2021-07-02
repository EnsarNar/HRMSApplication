package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hmrs.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementGetDto {
	
	private int id;
	private String employerCompanyName;
	private String jobPositionJobPosition;
	private String cityCityName;
	private LocalDate applicationDeadline;
	private String defination;
	private String workTime;
	private String workType;
	private String salary;
	private int numberOfOpenPositions;
	private boolean isActive;

	
	
}
