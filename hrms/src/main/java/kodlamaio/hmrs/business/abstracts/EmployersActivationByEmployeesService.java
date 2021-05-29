package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployersActivationByEmployeesService {
	Result confirmEmployer(Employer employer); // MİRAÇ ABİ BURAYA STRİNG COMPANYNAME GİRMİŞ
}
