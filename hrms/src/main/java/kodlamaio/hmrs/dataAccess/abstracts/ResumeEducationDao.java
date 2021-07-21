package kodlamaio.hmrs.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.ResumeEducation;


public interface ResumeEducationDao extends JpaRepository <ResumeEducation, Integer> {
	List<ResumeEducation> findById(int id);
	List<ResumeEducation> findAllByResumeId(int id);
	// DataResult<List<ResumeEducationGetDto>> findAllOrderedByGraduateDateEsc();
}
