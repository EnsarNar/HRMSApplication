package kodlamaio.hmrs.entities.concretes;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_positions")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobPosition {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="Bu alanı boş geçemezsin !")
	@Column(name="position")
	private String jobPosition;
	

	@OneToMany(mappedBy="jobPosition") // JobAdvertisement kısmındaki adını gireceksin (degiskenin adını)
	private List<JobAdvertisement> jobAdvertisements;

}