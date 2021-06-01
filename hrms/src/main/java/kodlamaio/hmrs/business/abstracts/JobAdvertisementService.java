package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdversitement);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> findByIsActiveOrderByApplicationDeadline(boolean isActive);
	DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);
}
