package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.LanguageDao;
import kodlamaio.hmrs.entities.concretes.Language;
import kodlamaio.hmrs.entities.dtos.LanguageAddDto;
import kodlamaio.hmrs.entities.dtos.LanguageGetDto;
@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public LanguageManager(LanguageDao languageDao,DtoConverterService dtoConverterService) {
			super();
			this.languageDao = languageDao;
			this.dtoConverterService = dtoConverterService;
		}
	@Override
	public DataResult<List<LanguageGetDto>> getAll() {
		return new SuccessDataResult<List<LanguageGetDto>>
		(this.dtoConverterService.dtoConverter(this.languageDao.findAll(), LanguageGetDto.class),"İşlem Başarılı");
		
	}
	@Override
	public Result add(LanguageAddDto languageAddDto) {
		this.languageDao.save((Language) this.dtoConverterService.dtoClassConverter(languageAddDto, Language.class));
		return new SuccessResult("İşlem Başarılı");
		
	}

	
}
