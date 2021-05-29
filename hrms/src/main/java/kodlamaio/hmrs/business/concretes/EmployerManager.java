package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private FieldService<Employer> employerFieldService;
	@Autowired
	public EmployerManager(FieldService<Employer> employerFieldService) {
		super();
		this.employerFieldService = employerFieldService;
	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return this.employerFieldService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.employerFieldService.add(employer);
	}



	
	


}
