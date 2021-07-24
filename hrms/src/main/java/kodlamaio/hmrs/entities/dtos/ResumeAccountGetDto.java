package kodlamaio.hmrs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAccountGetDto {

	private int resumeId;
	private int id;
	private String linkedin;
	private String github;
}

