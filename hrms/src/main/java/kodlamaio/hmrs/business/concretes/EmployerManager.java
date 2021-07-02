package kodlamaio.hmrs.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.ActivationCode;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private FieldService<Employer> employerFieldService;
	private ActivationCodeDao activationCodeDao;
	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(FieldService<Employer> employerFieldService,ActivationCodeDao activationCodeDao,EmployerDao employerDao) {
		super();
		this.employerFieldService = employerFieldService;
		this.activationCodeDao =activationCodeDao;
		this.employerDao = employerDao;
	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return this.employerFieldService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.employerFieldService.add(employer);
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



	
	


}
