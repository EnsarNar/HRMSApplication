package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeAccountAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeAccountGetDto;

public interface ResumeAccountService {
	DataResult<List<ResumeAccountGetDto>> getAll();
	Result add(ResumeAccountAddDto resumeAccountDto);
	DataResult<List<ResumeAccountGetDto>> findById(int id);
	DataResult<List<ResumeAccountGetDto>> findAllByResumeId(int id);
}
