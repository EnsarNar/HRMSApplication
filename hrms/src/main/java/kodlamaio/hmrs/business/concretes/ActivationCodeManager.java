package kodlamaio.hmrs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ActivationCodeService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hmrs.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	private ActivationCodeDao activationCodeDao;
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		this.activationCodeDao = activationCodeDao;
	}
	
	@Override
	public String createActivationCode() {
		ActivationCode activationCode = new ActivationCode();
		activationCode.setActivationCode("aktivasyonkodu1");
		return activationCode.getActivationCode();
	}

	@Override
	public void sendEmail(String email) {
		System.out.println("Doğrulama kodu için email gönderildi ->" + email);
		
	}

	@Override
	public Result verifyUserWithActivationCode(String code) {
		if(this.activationCodeDao.existsByActivationCode(code)) {
			return new SuccessResult("Doğrulama işleminiz başarılı.");
		}
		return new ErrorResult("Doğrulama işleminiz başarısız.");
	}

}
