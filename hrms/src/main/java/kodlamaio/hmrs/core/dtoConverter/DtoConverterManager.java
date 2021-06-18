package kodlamaio.hmrs.core.dtoConverter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DtoConverterManager implements DtoConverterService {
	
	private ModelMapper modelMapper;
	@Autowired
	public DtoConverterManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	@Override //Bu kısım dataları listelemek için.
	public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass) {
		return s.stream().map(element->modelMapper.map(element, targetClass)).collect(Collectors.toList());
	} // S ile gelen şey source yani kaynak. Kaynağımız, gelen verilerdir.
	//T ise targettir. Yani hedef. Gelen verileri, gedef olarak Dto'ya göndereceğiz.
	

	//Bu kısım data eklemek için.
	@Override 
	public <T> Object dtoClassConverter(Object source, Class<T> baseClass) {
		return modelMapper.map(source, baseClass);
	} //İlk T, taget. Yani direkt classımızın adı. Target classımız.

}
