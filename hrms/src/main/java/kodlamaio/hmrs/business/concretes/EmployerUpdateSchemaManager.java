package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerUpdateSchemaService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerUpdateSchemaDao;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.EmployerUpdateSchema;
import kodlamaio.hmrs.entities.dtos.EmployerUpdateSchemaAddDto;
import kodlamaio.hmrs.entities.dtos.EmployerUpdateSchemaGetDto;

@Service
public class EmployerUpdateSchemaManager implements EmployerUpdateSchemaService{

	@Autowired
	private EmployerUpdateSchemaDao employerUpdateSchemaDao;
	private DtoConverterService dtoConverterService;
	
	public EmployerUpdateSchemaManager(EmployerUpdateSchemaDao employerUpdateSchemaDao,DtoConverterService dtoConverterService) {
		super();
		this.employerUpdateSchemaDao = employerUpdateSchemaDao;
		this.dtoConverterService = dtoConverterService;
	}

	//Eğer tek bir updateEmployerUpdateSchema üzerinden güncellemeleri almaya çalışırsak
	//kişi aynı ande hem telefonunu hem emailini değiştiremez mesela.
	//telefonunu değiştirmek için istek atar sonrasında email için de istek atarsa EmployerUpdateSchema
	//Güncellenir ve sadece email kısmı kalır telefon kısmı gider. Ondan dolayı metodlar tek tek girildi.
	@Override
	public DataResult<List<EmployerUpdateSchemaGetDto>> getAll() {
		return new SuccessDataResult<List<EmployerUpdateSchemaGetDto>>
		(this.dtoConverterService.dtoConverter(this.employerUpdateSchemaDao.findAll(), EmployerUpdateSchemaGetDto.class),"İşlem Başarılı");
	}


	@Override
	public Result update(EmployerUpdateSchemaAddDto employerUpdateSchemaAddDto) {
//		String[] splittedMail = employerAddDto.getEmail().split("@");
//		// EMAİL KULLANILMIŞ MI
//		if(this.userDao.existsByEmail(employerAddDto.getEmail())) {
//			return new ErrorResult("Bu email çoktan kullanılmış !");
//		}
//		//DOĞRU DOMAİNLİ EMAİL Mİ
//		if (!employerAddDto.getWebAdress().contains(splittedMail[1])) {
//			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
//		}
//		//ŞİFRE TEKRARI İLE ŞİFRE AYNI MI
//		if(!employerAddDto.getPassword().equals(employerAddDto.getPassword_repeat())) {
//			return new ErrorResult("Şifre tekrarı ile şifre uyuşmuyor !");
//		}		
//		
//		this.employerDao.save((Employer) this.dtoConverterService.dtoClassConverter(employerAddDto, Employer.class));
		//return new SuccessResult("Tebrikler işlem başarılı.");
		employerUpdateSchemaAddDto.setOnUpdateProcess(true);
		this.employerUpdateSchemaDao.save((EmployerUpdateSchema) this.dtoConverterService.dtoClassConverter(employerUpdateSchemaAddDto, EmployerUpdateSchema.class));
		return new SuccessResult("İşlem Başarılı");
	}

	@Override
	public Result remove(int id) {
		EmployerUpdateSchema schema= this.employerUpdateSchemaDao.getById(id);
		schema.setOnUpdateProcess(false);
		this.employerUpdateSchemaDao.save(schema);
		return new SuccessResult("Process done");
	}

}
