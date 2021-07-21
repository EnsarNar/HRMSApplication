package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeExperienceGetDto {
	private int id;
	private int resumeId;
	private String companyName;
	private String position;
	private LocalDate startDate;
	private LocalDate endDate;


}
