package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;
// İŞ KODLARINDAN GEÇİRİP DATABASEYE EKLİYORUZ BURADA
@Service
public class JobPositionManager implements JobPositionService{
	
	private FieldService<JobPosition> jobPositionFieldService;
	@Autowired
	public JobPositionManager(FieldService<JobPosition> jobPositionFieldService) {
		super();
		this.jobPositionFieldService = jobPositionFieldService;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionFieldService.getAll();
	}
	@Override
	public Result add(JobPosition jobPosition) {
	return this.jobPositionFieldService.add(jobPosition);
	};
	

}
