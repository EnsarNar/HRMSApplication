package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.FavoriteForCandidateService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.FavoriteForCandidateDao;
import kodlamaio.hmrs.entities.concretes.FavoriteForCandidate;
import kodlamaio.hmrs.entities.dtos.FavoriteForCandidateDto;
@Service
public class FavoriteForCandidateManager implements FavoriteForCandidateService{

	private FavoriteForCandidateDao favoriteForCandidateDao;
	private DtoConverterService dtoConverterService;
	@Autowired
	public FavoriteForCandidateManager(FavoriteForCandidateDao favoriteForCandidateDao,DtoConverterService dtoConverterService) {
		super();
		this.favoriteForCandidateDao = favoriteForCandidateDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<FavoriteForCandidateDto>> getAll() {
		return new SuccessDataResult<List<FavoriteForCandidateDto>>
		(this.dtoConverterService.dtoConverter(favoriteForCandidateDao.findAll(), FavoriteForCandidateDto.class),"İşlem Başarılı");
		
	}

	@Override
	public Result add(FavoriteForCandidateDto favoriteForCandidateDto) {
		this.favoriteForCandidateDao.save((FavoriteForCandidate) this.dtoConverterService.dtoClassConverter(favoriteForCandidateDto, FavoriteForCandidate.class));
		return new SuccessResult("İşlem Başarılı");
	}
	
}
