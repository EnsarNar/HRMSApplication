package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeExperienceService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeExperienceDao;
import kodlamaio.hmrs.entities.concretes.ResumeEducation;
import kodlamaio.hmrs.entities.concretes.ResumeExperience;
import kodlamaio.hmrs.entities.dtos.ResumeExperienceAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeExperienceGetDto;
@Service
public class ResumeExperienceManager implements ResumeExperienceService {
	private DtoConverterService dtoConverterService;
	private ResumeExperienceDao resumeExperienceDao;
	@Autowired
	public ResumeExperienceManager(DtoConverterService dtoConverterService, ResumeExperienceDao resumeExperienceDao) {
		super();
		this.dtoConverterService = dtoConverterService;
		this.resumeExperienceDao = resumeExperienceDao;
	}
	
	@Override
	public DataResult<List<ResumeExperienceGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeExperienceGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeExperienceDao.findAll(), ResumeExperienceGetDto.class));		
	}
	
	@Override
	public Result add(ResumeExperienceAddDto resumeExperienceAddDto) {
		this.resumeExperienceDao.save((ResumeExperience) this.dtoConverterService.dtoClassConverter(resumeExperienceAddDto, ResumeExperience.class));
		return new SuccessResult("Tebrikler. İşlem başarılı.");
	}

	@Override
	public DataResult<List<ResumeExperienceGetDto>> findById(int id) {
		if(this.resumeExperienceDao.existsById(id)) {
			return new SuccessDataResult<List<ResumeExperienceGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeExperienceDao.findById(id), ResumeExperienceGetDto.class),"İşlem Başarılı");
		};
		return new ErrorDataResult<> ("Böyle bir veri bulunamadı.");
		
	}

	@Override
	public DataResult<List<ResumeExperienceGetDto>> findAllByResumeId(int id) {
		return new SuccessDataResult<List<ResumeExperienceGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeExperienceDao.findAllByResumeId(id),ResumeExperienceGetDto.class),"İşlem Başarılı");
	}

	@Override
	public Result update(ResumeExperienceAddDto resumeExperienceDto) {
		ResumeExperience experience =  (ResumeExperience)this.dtoConverterService.dtoClassConverter(resumeExperienceDto, ResumeEducation.class);
		 this.resumeExperienceDao.save(experience);
		return new SuccessResult("İşlem Başarılı");
		
	}
	

	

}
