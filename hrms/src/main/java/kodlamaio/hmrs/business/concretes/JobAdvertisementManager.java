package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvetisement) {
		this.jobAdvertisementDao.save(jobAdvetisement);
		return new SuccessResult("Tebrikler ! İşlem başarılı.");
	}
	
	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Tebrikler ! İşlem başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"Tüm iş ilanları görüntülendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActive(isActive),"Veriler getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveOrderByApplicationDeadline(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveOrderByApplicationDeadline(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(isActive, companyName));
	}

	

}
