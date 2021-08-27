package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.EmployerUpdateSchema;

public interface EmployerUpdateSchemaService {
	
	DataResult<List<EmployerUpdateSchema>> getAll();
	Result add(EmployerUpdateSchema employerUpdateSchema);
	Result updateEmail(String email,int id);
	Result updatePhone(String phone,int id);
	Result updateWebAdress(String webAdress,int id);
	Result updatePassword(String password,String passwordRepeat,int id);

}
