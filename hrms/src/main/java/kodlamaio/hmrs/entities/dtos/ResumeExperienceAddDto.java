package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeExperienceAddDto {
	
	private int resumeId;
	private String companyName;
	private String position;
	private LocalDate startDate;
	private LocalDate endDate;

}
