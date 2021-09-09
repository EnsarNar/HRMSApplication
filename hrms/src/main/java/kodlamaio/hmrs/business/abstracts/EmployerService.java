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
	Result update(EmployerAddDto employerAddDto);
//	Result update(EmployerAddDto EmployerAddDto);
	Result confirm(String activationCode);

}
