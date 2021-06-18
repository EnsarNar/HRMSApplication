package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeAccount;

public interface ResumeAccountDao extends JpaRepository<ResumeAccount,Integer>{

}
