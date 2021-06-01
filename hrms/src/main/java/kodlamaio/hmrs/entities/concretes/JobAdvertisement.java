package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="job_definition")
	private String defination;
	
	@ManyToOne()
	@JoinColumn(name="job_positions_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="salary")
	private String salary;
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="is_active")
	private boolean isActive = false; //başlarken false olarak başlayacak

}
