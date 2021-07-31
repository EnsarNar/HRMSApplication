package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeEducationAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeExperienceAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeExperienceGetDto;

public interface ResumeExperienceService {
	DataResult<List<ResumeExperienceGetDto>> getAll();
	Result add(ResumeExperienceAddDto resumeExperienceDto);
	Result update(ResumeExperienceAddDto resumeExperienceDto);
	DataResult<List<ResumeExperienceGetDto>> findById(int id);
	DataResult<List<ResumeExperienceGetDto>> findAllByResumeId(int id);
}
