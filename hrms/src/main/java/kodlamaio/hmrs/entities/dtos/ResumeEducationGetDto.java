package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEducationGetDto {
	
	private int resumeId;
	private String schoolName;
	private LocalDate startingDate;
	private LocalDate graduateDate;
	private String departmentName;
	
}
