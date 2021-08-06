package kodlamaio.hmrs.entities.concretes;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="profile_picture_url")
	private String profilePictureUrl;
	
	
//	@Column(name="created_at",updatable=false)
//	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdAt;
	
	@Column(name="created_at")
	private LocalDateTime createdAt =LocalDateTime.now();
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;

	
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL )
	private List<ResumeEducation> resumeEducation;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL )
	private List<ResumeExperience> resumeExperience;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL )
	private List<ResumeLanguage> resumeLanguage;
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL )
	private List<ResumeTechnology> resumeTechnology;
	@OneToMany(mappedBy="resume",cascade = CascadeType.ALL)
	private List<ResumeAccount> resumeAccount;

	@OneToOne(mappedBy = "resume")
	private ResumeCoverLetter resumeCoverLetter;
	

}
