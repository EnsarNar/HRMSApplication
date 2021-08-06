package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeCoverLetter;
import kodlamaio.hmrs.entities.concretes.ResumeEducation;


public interface ResumeCoverLetterDao extends JpaRepository<ResumeCoverLetter,Integer> {
	List<ResumeCoverLetter> getAllByResumeId(int id);

}
