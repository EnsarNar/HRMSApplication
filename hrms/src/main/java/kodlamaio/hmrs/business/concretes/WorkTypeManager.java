package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.WorkTypeService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.concretes.WorkType;
import kodlamaio.hmrs.entities.dtos.WorkTypeDto;

@Service
public class WorkTypeManager implements WorkTypeService {
	
	private WorkTypeDao workTypeDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao,DtoConverterService dtoConverterService) {
		super();
		this.workTypeDao = workTypeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<WorkTypeDto>> getAll() {
		return new SuccessDataResult<List<WorkTypeDto>>
		(this.dtoConverterService.dtoConverter(workTypeDao.findAll(), WorkTypeDto.class),"Datalar Getirildi");
	}

	@Override
	public Result add(WorkTypeDto workTypeDto) {
		this.workTypeDao.save((WorkType) this.dtoConverterService.dtoClassConverter(workTypeDto, WorkType.class));
		return new SuccessResult("İşlem Başarılı");
	}
	
	
}
