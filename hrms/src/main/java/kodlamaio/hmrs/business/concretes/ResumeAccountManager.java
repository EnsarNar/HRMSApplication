package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.business.abstracts.ResumeAccountService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeAccountDto;

@Service
public class ResumeAccountManager implements ResumeAccountService {
	private FieldService<ResumeAccountDto> resumeAccountDtoFieldService;
	@Autowired
	public ResumeAccountManager(FieldService<ResumeAccountDto> resumeAccountDtoFieldService) {
		super();
		this.resumeAccountDtoFieldService = resumeAccountDtoFieldService;
	}

	@Override
	public DataResult<List<ResumeAccountDto>> getAll() {
		return this.resumeAccountDtoFieldService.getAll();
	}

	@Override
	public Result add(ResumeAccountDto resumeAccountDto) {
		return this.resumeAccountDtoFieldService.add(resumeAccountDto);
	}
	


}
