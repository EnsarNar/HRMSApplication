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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resume_experiences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeExperience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@Column(name="company_name")
	private String companyName;
	

	@Column(name="position")
	private String position; //comany_name-start_date end_date
	

	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;
}
