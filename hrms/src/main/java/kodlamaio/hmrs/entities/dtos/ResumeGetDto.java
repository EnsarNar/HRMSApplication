package kodlamaio.hmrs.entities.dtos;


import java.time.LocalDateTime;
import java.util.List;

import kodlamaio.hmrs.entities.concretes.ResumeAccount;
import kodlamaio.hmrs.entities.concretes.ResumeEducation;
import kodlamaio.hmrs.entities.concretes.ResumeExperience;
import kodlamaio.hmrs.entities.concretes.ResumeLanguage;
import kodlamaio.hmrs.entities.concretes.ResumeTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeGetDto {	
	private int id; 
	private String coverLetter;
	private String profilePictureUrl;
	private String candidateFirstName;
	private String candidateLastName;
	private LocalDateTime createdAt;
	private List<ResumeEducation> resumeEducation;
	private List<ResumeExperience> resumeExperience;
	private List<ResumeLanguage> resumeLanguage;
	private List<ResumeTechnology> resumeTechnology;
	private List<ResumeAccount> resumeAccount;
	 
}
