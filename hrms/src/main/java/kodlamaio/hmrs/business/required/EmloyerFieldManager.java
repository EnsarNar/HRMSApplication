package kodlamaio.hmrs.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ActivationCodeService;
import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.Employer;
@Service
public class EmloyerFieldManager implements FieldService<Employer> {

	private UserDao userDao;
	private EmployerDao employerDao;
	private ActivationCodeService activationCodeService;

	@Autowired
	public EmloyerFieldManager(UserDao userDao, EmployerDao employerDao,ActivationCodeService activationCodeService) {
		super();
		this.userDao = userDao;
		this.employerDao = employerDao;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public Result add(Employer employer) {
		//MAİL SPLİTİ OLUŞTURMA
		String[] splittedMail = employer.getEmail().split("@");
		// EMAİL KULLANILMIŞ MI
				if(this.userDao.existsByEmail(employer.getEmail())) {
					return new ErrorResult("Bu email çoktan kullanılmış !");
				}
		//DOĞRU DOMAİNLİ EMAİL Mİ
		if (!splittedMail[1].equals(employer.getWebAdress())) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		//ŞİFRE TEKRARI İLE ŞİFRE AYNI MI
		if(!employer.getPassword().equals(employer.getPassword_repeat())) {
			return new ErrorResult("Şifre tekrarı ile şifre uyuşmuyor !");
		}		
		this.employerDao.save(employer);
		//Activation Code Simülasyonu
		this.activationCodeService.createActivationCode();
		this.activationCodeService.sendEmail(employer.getEmail());

		return new SuccessResult("Tebrikler ! kayıt işleminiz başarılı.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler(Şirketler) listelendi.");
	}

}
