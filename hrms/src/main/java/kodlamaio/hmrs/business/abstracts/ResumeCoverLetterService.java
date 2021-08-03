package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeCoverLetterAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeCoverLetterGetDto;

public interface ResumeCoverLetterService {
	DataResult<List<ResumeCoverLetterGetDto>> getAll();
	Result add(ResumeCoverLetterAddDto resumeCoverLetterAddDto);
}
