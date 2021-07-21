package kodlamaio.hmrs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAccountDto {
	private int id;
	private int resumeId;
	private String url;
	private String description;
}

