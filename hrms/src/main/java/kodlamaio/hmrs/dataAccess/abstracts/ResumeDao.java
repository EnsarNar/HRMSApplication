package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	
}
