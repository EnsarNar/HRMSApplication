package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED) 
//USER KISMI ABSTRACT OLARAK YAZILIP ENTİTİES KISMINA ALINACAK
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	

	@Column(name="id")
	private int id;
	
	@NotBlank(message="Şifre alanı boş olamaz.")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Lütfen şifre tekararını giriniz.")
	@Column(name="password_repeat")
	private String password_repeat;
	
	@Email(message="Lütfen geçerli bir email giriniz.")
	@NotBlank(message="email alanı boş olamaz.")
	@Column(name="email")
	private String email;

		
	
}
