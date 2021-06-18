package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.JobPositionAddDto;
import kodlamaio.hmrs.entities.dtos.JobPositionGetDto;


public interface JobPositionService {
	DataResult<List<JobPositionGetDto>> getAll();
	Result add(JobPositionAddDto jobPositionAddDto);

}
