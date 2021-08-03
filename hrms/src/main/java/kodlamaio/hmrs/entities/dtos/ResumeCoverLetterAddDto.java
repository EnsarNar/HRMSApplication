package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCoverLetterAddDto {

	private int id;
	private int resumeId;
	private String coverLetter;
	
}
