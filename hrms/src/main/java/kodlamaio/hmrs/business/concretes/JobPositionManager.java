package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;
import kodlamaio.hmrs.entities.dtos.JobPositionAddDto;
import kodlamaio.hmrs.entities.dtos.JobPositionGetDto;
// İŞ KODLARINDAN GEÇİRİP DATABASEYE EKLİYORUZ BURADA
@Service
public class JobPositionManager implements JobPositionService{
	
	
	private DtoConverterService dtoConverterService;
	private JobPositionDao jobPositionDao;
	@Autowired
	public JobPositionManager(FieldService<JobPosition> jobPositionFieldService, DtoConverterService dtoConverterService,JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.dtoConverterService = dtoConverterService;
	}
	@Override
	public DataResult<List<JobPositionGetDto>> getAll() {
		return new SuccessDataResult<List<JobPositionGetDto>>
		(this.dtoConverterService.dtoConverter(this.jobPositionDao.findAll(), JobPositionGetDto.class),"İşlem Başarılı.");
		
	}
	@Override
	public Result add(JobPositionAddDto jobPositionAddDto) {
		this.jobPositionDao.save((JobPosition) this.dtoConverterService.dtoClassConverter(jobPositionAddDto, JobPosition.class));
		return new SuccessResult("Tebrikler. İşlem başarılı.");
	}
	


}
