package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeLanguageAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeLanguageGetDto;

public interface ResumeLanguageService {
	DataResult<List<ResumeLanguageGetDto>> getAll();
	Result add(ResumeLanguageAddDto resumeLanguageAddDto);
	DataResult<List<ResumeLanguageGetDto>> findById(int id);
}
