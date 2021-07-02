package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.WorkTimeDto;


public interface WorkTimeService {
	DataResult<List<WorkTimeDto>> getAll();
	Result add(WorkTimeDto workTimeDto);
}
