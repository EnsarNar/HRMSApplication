package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.WorkTimeService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hmrs.entities.concretes.WorkTime;
import kodlamaio.hmrs.entities.dtos.WorkTimeDto;

@Service
public class WorkTimeManager implements WorkTimeService {
	private WorkTimeDao workTimeDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao,DtoConverterService dtoConverterService) {
		super();
		this.workTimeDao = workTimeDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	public DataResult<List<WorkTimeDto>> getAll() {
		return new SuccessDataResult<List<WorkTimeDto>>
		(this.dtoConverterService.dtoConverter(workTimeDao.findAll(), WorkTimeDto.class),"Datalar Geirildi");
	}

	@Override
	public Result add(WorkTimeDto workTimeDto) {
		this.workTimeDao.save((WorkTime) this.dtoConverterService.dtoClassConverter(workTimeDto, WorkTime.class));
		return new SuccessResult("İşlem Başarılı");
	}
}
