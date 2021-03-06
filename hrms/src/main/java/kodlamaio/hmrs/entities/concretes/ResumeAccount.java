package kodlamaio.hmrs.entities.concretes;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resume_accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class ResumeAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;
	
}
