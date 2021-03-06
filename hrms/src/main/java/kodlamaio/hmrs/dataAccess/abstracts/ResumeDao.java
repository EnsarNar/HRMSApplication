package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	
	List<Resume> getByCandidate_Id(int id);
	List<Resume> findById(int id);
	//List<Resume> findByCandidateIdAndIdGreaterThan(int CandidateId);
}
