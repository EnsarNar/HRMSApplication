package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService {
	
	private FieldService<Candidate> candidateFieldService;
	@Autowired
	public CandidateManager(FieldService<Candidate> candidateFieldService) {
		this.candidateFieldService = candidateFieldService;
	}

	@Override
	public Result add(Candidate candidate) {
		return this.candidateFieldService.add(candidate);
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return this.candidateFieldService.getAll();
		}
	

}
