package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeLanguageService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.hmrs.entities.concretes.ResumeLanguage;
import kodlamaio.hmrs.entities.dtos.ResumeLanguageAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeLanguageGetDto;

@Service
public class ReumeLanguageManager implements ResumeLanguageService {

	private ResumeLanguageDao resumeLanguageDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ReumeLanguageManager(ResumeLanguageDao resumeLanguageDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<ResumeLanguageGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeLanguageGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeLanguageDao.findAll(), ResumeLanguageGetDto.class));
	}

	@Override
	public Result add(ResumeLanguageAddDto resumeLanguageGetDto) {
		this.resumeLanguageDao.save((ResumeLanguage) this.dtoConverterService.dtoClassConverter(resumeLanguageGetDto, ResumeLanguage.class));
		return new SuccessResult("Tebrikler. İşlem başarılı");	
		}

}
