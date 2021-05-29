package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.EmployersActivationByEmployees;

public interface EmployersActivationByEmployeesDao extends JpaRepository<EmployersActivationByEmployees,Integer> {
//	boolean existsByEmployer_Id(int id); ->Simülasyon oldugu için yazılmadı
//	EmployersActivationByEmployees getByEmployer_Id(int id);
	
}
