package kodlamaio.hmrs.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;
@Service
public class JobPositionFieldManager implements FieldService<JobPosition>{
	
	private JobPositionDao jobPositionDao;
	@Autowired
	public JobPositionFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		//BU İŞ POZİSYONU ZATEN VAR MI KONTROLÜ 
		if(this.jobPositionDao.existsByJobPosition(jobPosition)) {
			return new ErrorResult("Zaten böyle bir iş pozisyonu var.");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Başarıyla iş pozisyonu eklendi");
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(),"Tüm iş pozisyonları listelendi.");
	}

}
