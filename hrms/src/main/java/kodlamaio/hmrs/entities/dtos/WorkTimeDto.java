package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTimeDto {
	
	private int id;
	@NotBlank(message="Bu kısım boş geçilemez")
	private String workTime;
}
