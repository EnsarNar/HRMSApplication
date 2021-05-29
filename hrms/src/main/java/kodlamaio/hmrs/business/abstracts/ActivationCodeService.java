package kodlamaio.hmrs.business.abstracts;

import kodlamaio.hmrs.core.utilities.results.Result;

public interface ActivationCodeService {
	
	String createActivationCode();
	
	void sendEmail(String email);
	
	Result verifyUserWithActivationCode(String code);
	
}
