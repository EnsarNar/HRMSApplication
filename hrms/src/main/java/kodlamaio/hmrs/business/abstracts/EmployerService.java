package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployerAddDto;
import kodlamaio.hmrs.entities.dtos.EmployerGetDto;


public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<List<EmployerGetDto>> getAllById(int id);
	Result add(EmployerAddDto employerAddDto);
//	Result update(EmployerAddDto EmployerAddDto);
	Result updateEmail(String email,int id);
	Result updatePhone(String phone,int id);
	Result updateWebAdress(String webAdress,int id);
	Result updatePassword(String password,String passwordRepeat,int id);
	Result confirm(String activationCode);

}
