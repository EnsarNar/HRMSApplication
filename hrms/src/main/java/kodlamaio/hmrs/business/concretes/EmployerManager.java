package kodlamaio.hmrs.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.ActivationCode;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployerAddDto;
import kodlamaio.hmrs.entities.dtos.EmployerGetDto;

@Service
public class EmployerManager implements EmployerService {

	private ActivationCodeDao activationCodeDao;
	private EmployerDao employerDao;
	private UserDao userDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public EmployerManager(ActivationCodeDao activationCodeDao,EmployerDao employerDao,UserDao userDao,DtoConverterService dtoConverterService) {
		super();
		
		this.activationCodeDao =activationCodeDao;
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.activationCodeDao = activationCodeDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Process's done");
		//(this.dtoConverterService.dtoConverter(this.employerDao.findAll(), EmployerGetDto.class),"İşlem Başarılı");
	}

	@Override
	public Result add(EmployerAddDto employerAddDto) {
		//MAİL SPLİTİ OLUŞTURMA
				String[] splittedMail = employerAddDto.getEmail().split("@");
				// EMAİL KULLANILMIŞ MI
				if(this.userDao.existsByEmail(employerAddDto.getEmail())) {
					return new ErrorResult("Bu email çoktan kullanılmış !");
				}
				//DOĞRU DOMAİNLİ EMAİL Mİ
				if (!employerAddDto.getWebAdress().contains(splittedMail[1])) {
					return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
				}
				//ŞİFRE TEKRARI İLE ŞİFRE AYNI MI
				if(!employerAddDto.getPassword().equals(employerAddDto.getPassword_repeat())) {
					return new ErrorResult("Şifre tekrarı ile şifre uyuşmuyor !");
				}		
				this.employerDao.save((Employer) this.dtoConverterService.dtoClassConverter(employerAddDto, Employer.class));
				return new SuccessResult("Tebrikler işlem başarılı.");
			
	}


	@Override
	public Result confirm(String activationCode) {
		if(!this.activationCodeDao.existsByActivationCode(activationCode)) {
			return new ErrorResult("Kod yok");
		}
		ActivationCode activationUserCode = this.activationCodeDao.getByActivationCode(activationCode);
		activationUserCode.setConfirmed(true);
		activationUserCode.setConfirmDate(LocalDate.now());
		this.activationCodeDao.save(activationUserCode);
		Employer employer = this.employerDao.findById(activationUserCode.getUser().getId()).get();
		employer.setActivated(true);
		this.employerDao.save(employer);
		return new SuccessResult("İşlem Başarılı");
	}


	@Override
	public DataResult<List<EmployerGetDto>> getAllById(int id) {
		return new SuccessDataResult<List<EmployerGetDto>>
		(this.dtoConverterService.dtoConverter(this.employerDao.getAllById(id), EmployerGetDto.class),"İşlem Başarılı");
	}


	@Override
	public Result updateEmail(String email, int id) {
		Employer updatedEmployer = this.employerDao.getById(id);
		// EMAİL KULLANILMIŞ MI
		if(this.userDao.existsByEmail(email)) {
			return new ErrorResult("Bu email çoktan kullanılmış !");
		}
	
//		updatedEmployer.setEmail(email);
//		Employer mainEmployer= this.employerDao.getById(id);	
//		mainEmployer.setUpdatedData(updatedEmployer);
		this.employerDao.save(updatedEmployer);
		return new SuccessResult("İşlem Başarılı");
	}


	@Override
	public Result updatePassword(String password, String passwordRepeat, int id) {
		Employer employer = this.employerDao.getById(id);
		if(!password.equals(passwordRepeat)) { 
			return new ErrorResult("Lütfen Şifre ile Şifre tekrarı aynı olsun");
		}else {
			
			employer.setPassword(password);
			employer.setPassword_repeat(passwordRepeat);
			this.employerDao.save(employer);
			return new SuccessResult("İşlem Başarılı");
		}
		
	
	}


	@Override
	public Result updatePhone(String phone, int id) {
		Employer employer = this.employerDao.getById(id);
		employer.setPhoneNumber(phone);
		this.employerDao.save(employer);
		return new SuccessResult("İşlem Başarılı");
	}


	@Override
	public Result updateWebAdress(String webAdress, int id) {
		Employer employer = this.employerDao.getById(id);
		employer.setWebAdress(webAdress);
		this.employerDao.save(employer);
		return new SuccessResult("İşlem Başarılı");
	}

	
};


	

	



	
	



