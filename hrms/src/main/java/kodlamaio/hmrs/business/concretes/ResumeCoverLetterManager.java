package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeCoverLetterDao;
import kodlamaio.hmrs.entities.concretes.ResumeCoverLetter;
import kodlamaio.hmrs.entities.dtos.ResumeCoverLetterAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeCoverLetterGetDto;

@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService {
	
	private ResumeCoverLetterDao resumeCoverLetterDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao,DtoConverterService dtoConverterService) {
		super();
		this.dtoConverterService = dtoConverterService;
		this.resumeCoverLetterDao = resumeCoverLetterDao;
	}
	@Override
	public DataResult<List<ResumeCoverLetterGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeCoverLetterGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeCoverLetterDao.findAll(), ResumeCoverLetterGetDto.class),"İşlem Başarılı");
	}
	@Override
	public Result add(ResumeCoverLetterAddDto resumeCoverLetterAddDto) {
		if(!this.resumeCoverLetterDao.existsById(resumeCoverLetterAddDto.getResumeId())) {
			this.resumeCoverLetterDao.save((ResumeCoverLetter) this.dtoConverterService.dtoClassConverter(resumeCoverLetterAddDto, ResumeCoverLetter.class));
		return new SuccessResult("İşlem Başarılı");
		}
		return new ErrorResult("İşlem Başarısız");
		
		
	}
	@Override
	public Result update(ResumeCoverLetterAddDto resumeCoverLetterAddDto) {
		ResumeCoverLetter coverLetter = (ResumeCoverLetter)this.dtoConverterService.dtoClassConverter(resumeCoverLetterAddDto, ResumeCoverLetter.class);
		this.resumeCoverLetterDao.save(coverLetter);
		return new SuccessResult("İşlem Başarılı");
		
	}
	@Override
	public DataResult<List<ResumeCoverLetterGetDto>> getAllByResumeId(int id) {
		return new SuccessDataResult<List<ResumeCoverLetterGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeCoverLetterDao.getAllByResumeId(id),ResumeCoverLetterGetDto.class) ,"İşlem Başarılı");
	}
}
