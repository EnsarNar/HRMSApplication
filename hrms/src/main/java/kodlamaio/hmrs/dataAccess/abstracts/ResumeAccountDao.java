package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeAccount;

public interface ResumeAccountDao extends JpaRepository<ResumeAccount,Integer>{
	List<ResumeAccount> findById(int id);
	List<ResumeAccount> findAllByResumeId(int id);
}
