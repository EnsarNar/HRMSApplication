package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.WorkTypeDto;

public interface WorkTypeService {
	DataResult<List<WorkTypeDto>> getAll();
	Result add(WorkTypeDto workTypeDto);
}
