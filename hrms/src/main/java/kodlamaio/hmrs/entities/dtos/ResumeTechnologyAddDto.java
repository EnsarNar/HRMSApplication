package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResumeTechnologyAddDto {
	private int resumeId;
	@NotBlank(message="Bu kısım boş geçilemez")
	private String programmingLanguageName;
	@NotBlank(message="Bu kısım boş geçilemez")
	private int grade;
}
