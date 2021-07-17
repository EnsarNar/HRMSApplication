package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeLanguageAddDto {
	private int id;
	private int resumeId;
	@NotBlank(message="Bu kısım boş geçilemez")
	private int languageId;
	@NotBlank(message="Bu kısım boş geçilemez")
	private int grade;

}
