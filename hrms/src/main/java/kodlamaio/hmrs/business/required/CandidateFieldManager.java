package kodlamaio.hmrs.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ActivationCodeService;
import kodlamaio.hmrs.business.abstracts.FieldService;
import kodlamaio.hmrs.core.adapters.MernisService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.Candidate;
@Service
public class CandidateFieldManager implements FieldService<Candidate> {

	
	private UserDao userDao;
	private CandidateDao candidateDao;
	private ActivationCodeService activationCodeService;
	private MernisService mernisService;
	@Autowired
	public CandidateFieldManager(UserDao userDao, CandidateDao candidateDao,ActivationCodeService activationCodeService,MernisService mernisService) {
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.activationCodeService =activationCodeService;
		this.mernisService = mernisService;
	}
	
	@Override
	public Result add(Candidate candidate) {
		//ŞİFRE TEKRARI İLE ŞİFRE AYNI MI
		if(!candidate.getPassword().equals(candidate.getPassword_repeat())) {
			return new ErrorResult("Şifreleriniz uyuşmuyor.");
		} 
		//AYNI TC NO'YA SAHİP KULLANICI VAR MI 
		if(candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu tc kimlik numarasına sahip başka bir kullanıcı var.");
		}
		//AYNI EMAİLE SAHİP KULLANICI VAR MI
		if(userDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Bu emaile sahip başka bir kullanıcı var.");
		}
		//MERNİS DOĞRULAMASI
		if(!mernisService.checkRealPerson()) {
			return new ErrorResult("Mernis doğrulaması gerçekleitirilemedi.");
		}
		
		
		this.candidateDao.save(candidate);
//		this.activationCodeService.createActivationCode();
//		this.activationCodeService.sendEmail(candidate.getEmail());
		return new SuccessResult("Tebrikler ! Başarı ile kayıt oldunuz.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Listeleme Başarılı");
	}

}
