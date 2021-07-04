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
	@NotBlank(message="Bu kısım boş geçilemez")
	private String companyName;
	@NotBlank(message="Bu kısım boş geçilemez")
	private String position;
	@NotBlank(message="Bu kısım boş geçilemez")
	private LocalDate startDate;
	@NotBlank(message="Bu kısım boş geçilemez")
	private LocalDate endDate;

}
