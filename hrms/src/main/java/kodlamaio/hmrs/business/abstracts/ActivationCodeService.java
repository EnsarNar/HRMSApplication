package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ActivationCodeAddDto;

public interface ActivationCodeService {
	
	
	Result addActivationCode(ActivationCodeAddDto activationCodeAddDto);
	
}
