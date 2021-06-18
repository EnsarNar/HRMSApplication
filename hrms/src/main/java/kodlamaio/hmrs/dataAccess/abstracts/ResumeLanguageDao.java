package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeLanguage;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer>{

}
