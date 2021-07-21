package kodlamaio.hmrs.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeAccountDao;
import kodlamaio.hmrs.entities.concretes.ResumeAccount;
import kodlamaio.hmrs.entities.dtos.ResumeAccountDto;
@Service
public class ResumeAccountFieldManager implements FieldService<ResumeAccountDto>{
	private ResumeAccountDao resumeAccountDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public ResumeAccountFieldManager(DtoConverterService dtoConverterService,ResumeAccountDao resumeAccountDao) {
		super();
		this.dtoConverterService = dtoConverterService;
		this.resumeAccountDao = resumeAccountDao;
	}
	@Override
	public Result add(ResumeAccountDto resumeAccountDto) {
		if(!resumeAccountDto.getUrl().contains("github.com/") &&
			!resumeAccountDto.getUrl().contains("linkedin.com/")) {
			return new ErrorResult("Lütfen Linkedin veya Github hesabı giriniz.");
		}
		
		this.resumeAccountDao.save((ResumeAccount) this.dtoConverterService.dtoClassConverter(resumeAccountDto, ResumeAccount.class));
		return new SuccessResult("İşlem Başarılı");
	}
	@Override
	public DataResult<List<ResumeAccountDto>> getAll() {
		return new SuccessDataResult<List<ResumeAccountDto>>
		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findAll(), ResumeAccountDto.class),"Datalar Getirildi");
	}
	

}
	
