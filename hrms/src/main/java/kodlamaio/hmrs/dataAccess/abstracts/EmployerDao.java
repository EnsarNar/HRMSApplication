package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
	List<Employer> getAllById(int id);
	Employer getById(int id);
}
