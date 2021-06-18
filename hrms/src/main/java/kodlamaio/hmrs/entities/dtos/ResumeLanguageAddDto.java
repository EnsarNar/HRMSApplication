package kodlamaio.hmrs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeLanguageAddDto {
	
	private int resumeId;
	private String languageName;
	private int grade;

}
