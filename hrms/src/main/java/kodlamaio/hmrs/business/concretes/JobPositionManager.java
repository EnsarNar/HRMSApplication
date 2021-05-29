package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;
// İŞ KODLARINDAN GEÇİRİP DATABASEYE EKLİYORUZ BURADA
@Service
public class JobPositionManager implements JobPositionService{
	
	@Autowired
	private JobPositionDao jobPositionsDao;
	public JobPositionManager(JobPositionDao jobPositionsDao) {
		this.jobPositionsDao = jobPositionsDao;
	}
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionsDao.findAll(),"İş pozisyonları başarılı bir şekide listelendi.");
	}
	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionsDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu sisteme eklendi.");
	};
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public List<JobPosition> getAll() {
//		return this.jobPositionsDao.findAll();
//	}

}
