package kodlamaio.hmrs.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteForCandidateDto {

	@JsonIgnore
	private int id;	
	private int candidateId;
	private int jobAdvertisementId;

}
