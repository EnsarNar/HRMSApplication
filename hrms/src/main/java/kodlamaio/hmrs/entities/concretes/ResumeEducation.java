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
@Table(name="resume_educations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEducation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	

	@Column(name="school_name")
	private String schoolName;
	

	@Column(name="start_date")
	private LocalDate startingDate;
	
	@Column(name="graduate_date")
	private LocalDate graduateDate;
 
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="is_gradudated")
	private boolean isGradudated=false;
	
	// @Column(name="gradudate_description")
	// private String gradudateDescription;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;

}
