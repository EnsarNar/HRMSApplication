package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.FavoriteForCandidateDto;

public interface FavoriteForCandidateService {
	DataResult<List<FavoriteForCandidateDto>> getAll();
	Result add(FavoriteForCandidateDto favoriteForCandidateDto);
}
