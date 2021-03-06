package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeEducationAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeEducationGetDto;

public interface ResumeEducationService {
	DataResult<List<ResumeEducationGetDto>> getAll();
	Result add(ResumeEducationAddDto resumeEducationAddDto);
	Result update(ResumeEducationAddDto resumeEducationDto);
	DataResult<List<ResumeEducationGetDto>> findById(int id);
	DataResult<List<ResumeEducationGetDto>> findAllByResumeId(int id);
}
