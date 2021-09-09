package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.EmployerUpdateSchemaAddDto;
import kodlamaio.hmrs.entities.dtos.EmployerUpdateSchemaGetDto;

public interface EmployerUpdateSchemaService {
	
	DataResult<List<EmployerUpdateSchemaGetDto>> getAll();
	Result update(EmployerUpdateSchemaAddDto employerUpdateSchemaAddDto);


}
