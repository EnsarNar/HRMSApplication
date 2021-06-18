package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementGetDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
		
	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<JobAdvertisementGetDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementGetDto>>
		(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAll(), JobAdvertisementGetDto.class),"Tebrikler işlem başarılı");
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		this.jobAdvertisementDao.save((JobAdvertisement) this.dtoConverterService.dtoClassConverter(jobAdvertisementAddDto, JobAdvertisement.class));
		return new SuccessResult("Tebrikler işlem başarılı.");
	}

	@Override
	public DataResult<List<JobAdvertisementGetDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementGetDto>>
		(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobAdvertisementGetDto.class),"Data Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementGetDto>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisementGetDto>>
		(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAll(sort), JobAdvertisementGetDto.class),"Tebrikler");
	}

	@Override
	public DataResult<List<JobAdvertisementGetDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementGetDto>>
		(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findByIsActive(true), JobAdvertisementGetDto.class),"Datalar Getirildi");
	}



}
