package kodlamaio.hmrs.core.adapters;

import kodlamaio.hmrs.Mernis.MernisManager;

public class MernisAdapter implements MernisService {
	
	MernisManager mernisManager = new MernisManager();
	

	@Override
	public boolean checkRealPerson() {
		return this.mernisManager.isRealPerson();
	}

	
	

	

}
