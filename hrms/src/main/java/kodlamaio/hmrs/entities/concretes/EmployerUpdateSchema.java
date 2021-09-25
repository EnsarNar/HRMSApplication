package kodlamaio.hmrs.entities.concretes;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
@Table(name="employer_update_schemas")
public class EmployerUpdateSchema {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="password")
	private String password;
	
	@Column(name="password_repeat")
	private String passwordRepeat;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="on_update_process")
	private boolean onUpdateProcess=true;
	
	@Column(name="created_at")
	private LocalDateTime createdAt=LocalDateTime.now();
	
}
