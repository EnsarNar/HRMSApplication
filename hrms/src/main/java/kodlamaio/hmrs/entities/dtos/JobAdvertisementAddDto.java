package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementAddDto {
	
	@Id
	private int id;
	private int jobPositionId;
	private int employerId;
	private int cityId;
	private LocalDate applicationDeadline;
	private String defination;
	private String salary;
	private int numberOfOpenPositions;

}
