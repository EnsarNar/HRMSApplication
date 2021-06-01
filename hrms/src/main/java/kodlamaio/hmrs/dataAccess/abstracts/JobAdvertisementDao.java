package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	List<JobAdvertisement> findByIsActive(boolean isActive);
	List<JobAdvertisement> findByIsActiveOrderByApplicationDeadline(boolean isActive);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
