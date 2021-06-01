package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
public class Employee extends User{
	
	@NotBlank(message="lütfen adınızı giriniz.")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="lütfen adınızı giriniz.")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="Lütfen doğum tarihinizi giriniz.")
	@Column(name="birth_date")
	private LocalDate birthDate;
	

}
