package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeAccountService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeAccountDao;
import kodlamaio.hmrs.entities.concretes.ResumeAccount;
import kodlamaio.hmrs.entities.dtos.ResumeAccountAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeAccountGetDto;

@Service
public class ResumeAccountManager implements ResumeAccountService {
	private DtoConverterService dtoConverterService;
	private ResumeAccountDao resumeAccountDao;
	@Autowired
	public ResumeAccountManager(DtoConverterService dtoConverterService,ResumeAccountDao resumeAccountDao) {
		super();
		
		this.dtoConverterService = dtoConverterService;
		this.resumeAccountDao = resumeAccountDao;
	}

	@Override
	public DataResult<List<ResumeAccountGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeAccountGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findAll(), ResumeAccountGetDto.class),"Datalar Getirildi");
	}

	@Override
	public Result add(ResumeAccountAddDto resumeAccountDto) {
		if(!resumeAccountDto.getGithub().contains("github.com/") &&
				!resumeAccountDto.getLinkedin().contains("linkedin.com/")) {
				return new ErrorResult("Lütfen Linkedin veya Github hesabı giriniz.");
			}
			
			this.resumeAccountDao.save((ResumeAccount) this.dtoConverterService.dtoClassConverter(resumeAccountDto, ResumeAccount.class));
			return new SuccessResult("İşlem Başarılı");
	}

	@Override
	public DataResult<List<ResumeAccountGetDto>> findById(int id) {
		if(this.resumeAccountDao.existsById(id)) {
			return new SuccessDataResult<List<ResumeAccountGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findById(id), ResumeAccountGetDto.class),"İşlem Başarılı");
		};
		return new ErrorDataResult<> ("Böyle bir veri bulunamadı.");
	}

	@Override
	public DataResult<List<ResumeAccountGetDto>> findAllByResumeId(int id) {
		return new SuccessDataResult<List<ResumeAccountGetDto>>
		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findAllByResumeId(id), ResumeAccountGetDto.class),"İşlem Başarılı.");
	}


//	@Override
//	public Result add(ResumeAccount resumeAccount) {
//		if(!resumeAccount.getGithub().contains("github.com/") &&
//			!resumeAccount.getLinkedin().contains("linkedin.com/")) {
//			return new ErrorResult("Lütfen Linkedin veya Github hesabı giriniz.");
//		}
//		
//		this.resumeAccountDao.save((ResumeAccount) this.dtoConverterService.dtoClassConverter(resumeAccountDto, ResumeAccount.class));
//		return new SuccessResult("İşlem Başarılı");
//	}
//	
//	@Override
//	public DataResult<List<ResumeAccountDto>> getAll() {
//		return new SuccessDataResult<List<ResumeAccountDto>>
//		(this.dtoConverterService.dtoConverter(this.resumeAccountDao.findAll(), ResumeAccountDto.class),"Datalar Getirildi");
//	}

}
