package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeAccountDto;

public interface ResumeAccountService {
	DataResult<List<ResumeAccountDto>> getAll();
	Result add(ResumeAccountDto resumeAccountDto);
	DataResult<List<ResumeAccountDto>> findById(int id);
	DataResult<List<ResumeAccountDto>> findAllByResumeId(int id);
}
