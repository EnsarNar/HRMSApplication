package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerUpdateSchemaService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerUpdateSchemaDao;
import kodlamaio.hmrs.entities.concretes.EmployerUpdateSchema;

@Service
public class EmployerUpdateSchemaManager implements EmployerUpdateSchemaService{

	@Autowired
	private EmployerUpdateSchemaDao employerUpdateSchemaDao;
	
	public EmployerUpdateSchemaManager(EmployerUpdateSchemaDao employerUpdateSchemaDao) {
		super();
		this.employerUpdateSchemaDao = employerUpdateSchemaDao;
	}

	//Eğer tek bir updateEmployerUpdateSchema üzerinden güncellemeleri almaya çalışırsak
	//kişi aynı ande hem telefonunu hem emailini değiştiremez mesela.
	//telefonunu değiştirmek için istek atar sonrasında email için de istek atarsa EmployerUpdateSchema
	//Güncellenir ve sadece email kısmı kalır telefon kısmı gider. Ondan dolayı metodlar tek tek girildi.
	@Override
	public DataResult<List<EmployerUpdateSchema>> getAll() {
		return new SuccessDataResult<List<EmployerUpdateSchema>>
		(this.employerUpdateSchemaDao.findAll(),"İşlem Başarılı");
	}

	@Override
	public Result updateEmail(String email, int id) {
		EmployerUpdateSchema schema = this.employerUpdateSchemaDao.getById(id);
		schema.setEmail(email);
		this.employerUpdateSchemaDao.save(schema);
		return new SuccessResult("İşlem Başarılı");
	}

	@Override
	public Result updatePhone(String phone, int id) {
		EmployerUpdateSchema schema = this.employerUpdateSchemaDao.getById(id);
		schema.setPhoneNumber(phone);
		this.employerUpdateSchemaDao.save(schema);
		return new SuccessResult("İşlem Başarılı");
	}

	@Override
	public Result updateWebAdress(String webAdress, int id) {
		EmployerUpdateSchema schema = this.employerUpdateSchemaDao.getById(id);
		schema.setWebAdress(webAdress);
		this.employerUpdateSchemaDao.save(schema);
		return new SuccessResult("İşlem Başarılı");
	}

	@Override
	public Result updatePassword(String password, String passwordRepeat, int id) {
		if(password.equals(passwordRepeat)) {
			EmployerUpdateSchema schema = this.employerUpdateSchemaDao.getById(id);
		schema.setPassword(password);
		schema.setPasswordRepeat(passwordRepeat);
		this.employerUpdateSchemaDao.save(schema);
		return new SuccessResult("İşlem Başarılı");
		}
		return new ErrorResult("Şifre tekrarı ile şifre uyuşmuyor !");
		
	}

	@Override
	public Result add(EmployerUpdateSchema employerUpdateSchema) {
		this.employerUpdateSchemaDao.save(employerUpdateSchema);
		return new SuccessResult("İşlem Başarılı");
	}

}
