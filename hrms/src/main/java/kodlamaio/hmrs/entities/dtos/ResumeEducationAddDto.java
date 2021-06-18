package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEducationAddDto {

	//private int id; education idsi
	private int resumeId;
	private String schoolName;
	private LocalDate startingDate;
	private LocalDate graduateDate;
	private String departmentName;
	
}
