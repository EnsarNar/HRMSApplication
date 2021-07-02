package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.CityDao;
import kodlamaio.hmrs.entities.dtos.CityDto;

@Service
public class CityManager implements CityService {
	private CityDao cityDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public CityManager(CityDao cityDao, DtoConverterService dtoConverterService) {
		super();
		this.cityDao = cityDao;
		this.dtoConverterService = dtoConverterService;
	}
	

	
	@Override
	public DataResult<List<CityDto>> getAll() {
		return new SuccessDataResult<List<CityDto>>
		(this.dtoConverterService.dtoConverter(this.cityDao.findAll(), CityDto.class),"İşlem Başarılı");
		
	};
	
	
	
	
}
