package kodlamaio.hmrs.entities.concretes;

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
@Table(name="employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = false)
public class Employer extends User{
	
	@NotBlank(message="Şirket adı zorunludur.")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Telefon numarası zorunludur.")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotBlank(message="Web adresinizi giriniz.")
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="is_activated")
	private boolean isActivated;
	

	
	
	

}
