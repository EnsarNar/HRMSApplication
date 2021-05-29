package kodlamaio.hmrs.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployersActivationByEmployeesService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.Employer;
@Service
public class EmployersActivationByEmployeesManager implements EmployersActivationByEmployeesService {

	@Override
	public Result confirmEmployer(Employer employer) {
		//SİMÜLE EDİLDİ SİMÜLE EDİLDİ
		return new SuccessResult("Şirket başarıyla doğrulandı. ->" + employer.getCompanyName());
		
	}

}
