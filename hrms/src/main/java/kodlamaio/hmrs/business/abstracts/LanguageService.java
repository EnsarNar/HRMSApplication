package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.LanguageAddDto;
import kodlamaio.hmrs.entities.dtos.LanguageGetDto;

public interface LanguageService {
	DataResult<List<LanguageGetDto>> getAll();
	Result add(LanguageAddDto languageAddDto);
}
