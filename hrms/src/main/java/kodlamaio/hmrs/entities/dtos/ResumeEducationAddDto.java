package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEducationAddDto {

	//private int id; education idsi
	private int resumeId;
	@NotBlank(message="Bu kısım boş geçilemez")
	private String schoolName;
	@NotBlank(message="Bu kısım boş geçilemez")
	private LocalDate startingDate;
	@NotBlank(message="Bu kısım boş geçilemez")
	private LocalDate graduateDate;
	private String departmentName;
	
}
