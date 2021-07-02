package kodlamaio.hmrs.entities.dtos;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementFilter {
	
	private List<Integer> jobPositionId;

	private List<Integer> cityId;

	private List<Integer> workTypeId;

	private List<Integer> workTimeId;
}
