package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementFilter;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementGetDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementGetDto>> getAll();
	DataResult<List<JobAdvertisementGetDto>> getAllSorted();
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	DataResult<List<JobAdvertisementGetDto>> findByIsActive();
	DataResult<List<JobAdvertisementGetDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvertisementGetDto>> findByIsNotActive();
	Result changeIsActiveOfJobAdvertisement(int id);
	DataResult<Page<JobAdvertisement>> getByFilterWithPages(JobAdvertisementFilter jobAdvertisementFilter, int pageNo,int pageSize);
	//Yukarıdaki metodda normalde isActive bilgisi girilmedi diye sorabilirsin.
	//Bunun sebebi, kullancıın isActive bilgisini girmemesi gerektigindendir.
	//Otomatikmen true olan bütün verilerin gelmesi lazım.
}
