package kodlamaio.hmrs.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id") // Buraya şu an bulundugumuz classtaki primary key idsinin alanı yazılır eger bu idnin ismi ile base classtaki idnin ismi aynıysa yazmana gerek yok.
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	@NotBlank(message="Lütfen adınızı giriniz.")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Lütfen adınızı giriniz.")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="Lütfen kimlik numaranızı giriniz.")
	@Size(min=11, max=11, message="Tc kimlik numarası 11 haneli olmalıdır.")
	@Column(name="identity_number")
	private String identityNumber; // TC Kimlik Numarası
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
}
