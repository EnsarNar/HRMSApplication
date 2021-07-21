package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeTechnologyService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeTechnologyDao;
import kodlamaio.hmrs.entities.concretes.ResumeTechnology;
import kodlamaio.hmrs.entities.dtos.ResumeTechnologyAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeTechnologyGetDto;
@Service
public class ResumeTechnologyManager implements ResumeTechnologyService {

	private ResumeTechnologyDao resumeTechnologyDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ResumeTechnologyManager(ResumeTechnologyDao resumeTechnologyDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeTechnologyDao = resumeTechnologyDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<ResumeTechnologyGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeTechnologyGetDto>>
		(this.dtoConverterService.dtoConverter(resumeTechnologyDao.findAll(), ResumeTechnologyGetDto.class));
	}

	@Override
	public Result add(ResumeTechnologyAddDto resumeTechnologyAddDto) {
		this.resumeTechnologyDao.save((ResumeTechnology) this.dtoConverterService.dtoClassConverter(resumeTechnologyAddDto, ResumeTechnology.class));
		return new SuccessResult("Tebrikler. İşlem başarılı.");
	}

	@Override
	public DataResult<List<ResumeTechnologyGetDto>> findById(int id) {
		if(this.resumeTechnologyDao.existsById(id)) {
			return new SuccessDataResult<List<ResumeTechnologyGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeTechnologyDao.findById(id), ResumeTechnologyGetDto.class),"İşlem Başarılı");
		};
		return new ErrorDataResult<> ("Böyle bir veri bulunamadı");
		
	}

}
