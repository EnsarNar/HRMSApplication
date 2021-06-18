package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	public List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName); 
	public List<JobAdvertisement> findByIsActive(boolean isActive);
	
	//Ben buraya query metodu yazınca daonun içerisinde böyle bir sorgulu metodu aktifleştiriyormuşlum gibisinden bir şeyo luyor
}
