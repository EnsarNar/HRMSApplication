package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeEducationService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeEducationDao;
import kodlamaio.hmrs.entities.concretes.ResumeEducation;
import kodlamaio.hmrs.entities.dtos.ResumeEducationAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeEducationGetDto;
import kodlamaio.hmrs.entities.dtos.ResumeGetDto;
@Service
public class ResumeEducationManager implements ResumeEducationService{
	private ResumeEducationDao resumeEducationDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao,DtoConverterService dtoConverterService) {
		super();
		this.resumeEducationDao = resumeEducationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<ResumeEducationGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeEducationGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeEducationDao.findAll(), ResumeEducationGetDto.class));
	}

	@Override
	public Result add(ResumeEducationAddDto resumeEducationAddDto) {
		this.resumeEducationDao.save((ResumeEducation) this.dtoConverterService.dtoClassConverter(resumeEducationAddDto, ResumeEducation.class));
		return new SuccessResult("Tebrikler. İşlem başarılı");
	}

	@Override
	public DataResult<List<ResumeEducationGetDto>> findById(int id) {
		if(this.resumeEducationDao.existsById(id)) {
			return new SuccessDataResult<List<ResumeEducationGetDto>>
		(this.dtoConverterService.dtoConverter(resumeEducationDao.findById(id), ResumeEducationGetDto.class),"Aferin başardın");
		}
		
		return new ErrorDataResult<>("Böyle Bir Resume Yok !");
	}

	@Override
	public DataResult<List<ResumeEducationGetDto>> findByResumeId(int id) {
		return new SuccessDataResult<List<ResumeEducationGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeEducationDao.findByResumeId(id),ResumeEducationGetDto.class ),"İşlem Başarılı");
	}

}
