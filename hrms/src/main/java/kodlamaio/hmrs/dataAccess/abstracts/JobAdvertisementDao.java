package kodlamaio.hmrs.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementFilter;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	 List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName); 
	 List<JobAdvertisement> findByIsActive(boolean isActive);
	@Query("From JobAdvertisement where isActive=false order by applicationDeadline Desc ")
	 List<JobAdvertisement> findByIsNotActive();
	@Query("Select j from kodlamaio.hmrs.entities.concretes.JobAdvertisement j where"
			+ " ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
	        +" and ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
	        +" and ((:#{#filter.workTimeId}) IS NULL OR j.workTime.id IN (:#{#filter.workTimeId}))"
	        +" and j.isActive=true")
	Page<JobAdvertisement> getByFilter(@Param("filter")JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);
	//+ "and j.isConfirm = true"
	//başlarındaki public silindi.
	//+" and (cast((:#{#filter.date}) AS timestamp)  IS NULL OR j.releaseDate<=(:#{#filter.date}))"
	
	//Ben buraya query metodu yazınca daonun içerisinde böyle bir sorgulu metodu aktifleştiriyormuşlum gibisinden bir şeyo luyor
}
