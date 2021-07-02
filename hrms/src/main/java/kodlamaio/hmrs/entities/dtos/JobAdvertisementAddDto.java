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
	
	 private int id;
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private int workTypeId;
	private int workTimeId;
	private LocalDate applicationDeadline;
	private String defination;
	private String salary;
	private int numberOfOpenPositions;

}
