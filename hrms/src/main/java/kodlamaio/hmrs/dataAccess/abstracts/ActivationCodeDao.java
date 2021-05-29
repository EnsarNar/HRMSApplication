package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer> {
	
	ActivationCode getByActivationCode(String code);
	boolean existsByActivationCode(String code);
}
