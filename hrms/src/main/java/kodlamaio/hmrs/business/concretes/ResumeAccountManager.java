package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.business.abstracts.ResumeAccountService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeAccountDao;
import kodlamaio.hmrs.entities.dtos.ResumeAccountDto;

@Service
public class ResumeAccountManager implements ResumeAccountService {
	private FieldService<ResumeAccountDto> resumeAccountDtoFieldService;
	private DtoConverterService dtoConverterService;
	private ResumeAccountDao resumeAccountDao;
	@Autowired
	public ResumeAccountManager(FieldService<ResumeAccountDto> resumeAccountDtoFieldService,DtoConverterService dtoConverterService,ResumeAccountDao resumeAccountDao) {
		super();
		this.resumeAccountDtoFieldService = resumeAccountDtoFieldService;
		this.dtoConverterService = dtoConverterService;
		this.resumeAccountDao = resumeAccountDao;
	}

	@Override
	public DataResult<List<ResumeAccountDto>> getAll() {
		return this.resumeAccountDtoFieldService.getAll();
	}

	@Override
	public Result add(ResumeAccountDto resumeAccountDto) {
		return this.resumeAccountDtoFieldService.add(resumeAccountDto);
	}

	@Override
	public DataResult<List<ResumeAccountDto>> findById(int id) {
		if(this.resumeAccountDao.existsById(id)) {
			return new SuccessDataResult<List<ResumeAccountDto>>
		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findById(id), ResumeAccountDto.class),"İşlem Başarılı");
		};
		return new ErrorDataResult<> ("Böyle bir veri bulunamadı.");
	}

	@Override
	public DataResult<List<ResumeAccountDto>> findByResumeId(int id) {
		return new SuccessDataResult<List<ResumeAccountDto>>
		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findByResumeId(id), ResumeAccountDto.class),"İşlem Başarılı.");
	}


	


}
