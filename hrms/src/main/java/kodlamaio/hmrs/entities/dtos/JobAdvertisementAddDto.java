package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementAddDto {
	
	 private int id;
	 @NotBlank(message="Bu kısım boş geçilemez")
	private int employerId;
	 @NotBlank(message="Bu kısım boş geçilemez")
	private int jobPositionId;
	 @NotBlank(message="Bu kısım boş geçilemez")
	private int cityId;
	 @NotBlank(message="Bu kısım boş geçilemez")
	private int workTypeId;
	@NotBlank(message="Bu kısım boş geçilemez")
	private int workTimeId;
	@NotBlank(message="Bu kısım boş geçilemez")
	private LocalDate applicationDeadline;
	@NotBlank(message="Bu kısım boş geçilemez")
	private String defination;
	@NotBlank(message="Bu kısım boş geçilemez")
	private String salary;
	@NotBlank(message="Bu kısım boş geçilemez")
	private int numberOfOpenPositions;

}
