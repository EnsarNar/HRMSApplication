package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeCoverLetter;


public interface ResumeCoverLetterDao extends JpaRepository<ResumeCoverLetter,Integer> {

}
