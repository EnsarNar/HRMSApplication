package kodlamaio.hmrs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeTechnologyGetDto {
	
	private int resumeId;
	private int id;
	private String programmingLanguageName;
	private int grade;
	
}
