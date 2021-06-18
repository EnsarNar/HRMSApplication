package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementGetDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementGetDto>> getAll();
	DataResult<List<JobAdvertisementGetDto>> getAllSorted();
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	DataResult<List<JobAdvertisementGetDto>> findByIsActive();
	DataResult<List<JobAdvertisementGetDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
	//Yukarıdaki metodda normalde isActive bilgisi girilmedi diye sorabilirsin.
	//Bunun sebebi, kullancıın isActive bilgisini girmemesi gerektigindendir.
	//Otomatikmen true olan bütün verilerin gelmesi lazım.
}
