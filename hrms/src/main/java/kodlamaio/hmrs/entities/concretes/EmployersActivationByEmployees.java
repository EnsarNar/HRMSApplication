package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers_activation_by_employees")
public class EmployersActivationByEmployees {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@OneToOne(targetEntity = Employer.class)
//	@JoinColumn(name="id",referencedColumnName="id") // ilki employer_id ikincisi user_id
//	private Employer employer;
	
//	@OneToOne(targetEntity=Employee.class)
//	@JoinColumn(name="id", referencedColumnName="id")	SİMÜLASYON OLDUGU İÇİN BURAYA ŞU ANLIK GEREK YOK
//	private Employee employee; 
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="employee_id")
	private int employeeId;
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="confirm_date")
	private LocalDate confirmDate;
	
	@Column(name="is_confirmed")
	private boolean isConformed;

	

}
