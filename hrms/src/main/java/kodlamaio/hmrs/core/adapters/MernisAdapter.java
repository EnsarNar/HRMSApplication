package kodlamaio.hmrs.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.Mernis.MernisManager;
@Service
public class MernisAdapter implements MernisService {
	

	@Override
	public boolean checkRealPerson() {
		MernisManager mernisManager = new MernisManager();
		return mernisManager.isRealPerson();
	}

	
	

	

}
