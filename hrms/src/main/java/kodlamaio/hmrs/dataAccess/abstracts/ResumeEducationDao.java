package kodlamaio.hmrs.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeEducation;


public interface ResumeEducationDao extends JpaRepository <ResumeEducation, Integer> {
	// DataResult<List<ResumeEducationGetDto>> findAllOrderedByGraduateDateEsc();
}
