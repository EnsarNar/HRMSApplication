package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeTechnologyAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeTechnologyGetDto;

public interface ResumeTechnologyService {
	DataResult<List<ResumeTechnologyGetDto>> getAll();
	Result add(ResumeTechnologyAddDto resumeTechnologyAddDto);
}
