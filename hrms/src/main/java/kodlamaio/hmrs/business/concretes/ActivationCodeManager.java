package kodlamaio.hmrs.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ActivationCodeService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.ActivationCode;
import kodlamaio.hmrs.entities.dtos.ActivationCodeAddDto;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	private ActivationCodeDao activationCodeDao;
	private UserDao userDao;
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao,UserDao userDao) {
		this.activationCodeDao = activationCodeDao;
		this.userDao = userDao;
	}
	

	@Override
	public Result addActivationCode(ActivationCodeAddDto activationCodeAddDto) {
		if(!this.userDao.existsById(activationCodeAddDto.getUserId())) {
			return new ErrorResult("hata mesajı");
		}
		ActivationCode acticationCode = new ActivationCode();
		acticationCode.setUser(this.userDao.findById(activationCodeAddDto.getUserId()).get());
		acticationCode.setActivationCode(MD5(acticationCode.getUser().getEmail())+MD5(LocalDate.now().toString()));    
		acticationCode.setConfirmed(false);
		this.activationCodeDao.save(acticationCode);
		return new SuccessResult("Başarılı.");
	}
	private String MD5(String md5) {            try {                 java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");                 byte[] array = md.digest(md5.getBytes());                 StringBuffer sb = new StringBuffer();                 for (int i = 0; i < array.length; ++i) {                   sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));                }                 return sb.toString();             } catch (java.security.NoSuchAlgorithmException e) {             }             return null;         }

}
