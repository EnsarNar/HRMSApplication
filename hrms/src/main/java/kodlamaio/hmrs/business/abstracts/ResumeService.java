package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeGetDto;

public interface ResumeService {
	DataResult<List<ResumeGetDto>> getAll();
	Result add(ResumeAddDto resumeDto);
	Result saveImage(MultipartFile file, int id);
	Result delete(int id);
	DataResult<List<ResumeGetDto>> getByCandidateId(int id);

}
