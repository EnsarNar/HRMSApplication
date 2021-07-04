package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPositionAddDto {
	 private int id;
	 @NotBlank(message="Bu kısım boş geçilemez")
	 private String jobPosition;

}
