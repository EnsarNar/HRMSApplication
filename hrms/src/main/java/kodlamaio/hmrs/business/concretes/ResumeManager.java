package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.Cloudinary.CloudinaryService;
import kodlamaio.hmrs.core.dtoConverter.DtoConverterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeDao;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.dtos.ResumeAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeGetDto;
@Service
public class ResumeManager implements ResumeService{

	private DtoConverterService dtoConverterService;
	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	@Autowired
	public ResumeManager(DtoConverterService dtoConverterService,ResumeDao resumeDao, CloudinaryService cloudinaryService) {
		super();
		this.dtoConverterService = dtoConverterService;
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeGetDto>>
		(this.dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeGetDto.class),"Aferin başardın");
	}				//resumedao.findall bana bir liste döndürecek. Veriler buradan geliyor. Bu bir kaynak.

	

	@Override
	public Result add(ResumeAddDto resumeDto) {
		this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("Kayıt basarili");
	}
	
	


	@Override // User'ın idsi olacak su anda resumenin idsi.
	public Result saveImage(MultipartFile file, int id) {
		@SuppressWarnings("unchecked")
        Map<?, String> uploader = (Map<?, String>) 
                cloudinaryService.save(file).getData(); 
        String imageUrl= uploader.get("url");
        Resume Cv = resumeDao.getOne(id);
        Cv.setProfilePictureUrl(imageUrl);
        resumeDao.save(Cv);
        return new SuccessResult("Kayıt Başarılı");
		
	}

	@Override
	public Result delete(int id) {
		this.resumeDao.deleteById(id);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<List<ResumeGetDto>> getByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeGetDto>>
		(this.dtoConverterService.dtoConverter(resumeDao.getByCandidate_Id(id), ResumeGetDto.class),"Aferin başardın");

	}

	@Override
	public DataResult<List<ResumeGetDto>> findById(int id) {
		if(this.resumeDao.existsById(id)) {
			return new SuccessDataResult<List<ResumeGetDto>>
		(this.dtoConverterService.dtoConverter(resumeDao.findById(id), ResumeGetDto.class),"Aferin başardın");
		}
		
		return new ErrorDataResult<>("Böyle Bir Resume Yok !");
		
	}

	


	

	//@Override
	//public DataResult<List<ResumeGetDto>> findByCandidateIdAndIdGreaterThan(int CandidateId) {
		//return new SuccessDataResult<List<ResumeGetDto>>
		//(this.dtoConverterService.dtoConverter(resumeDao.findByCandidateIdAndIdGreaterThan(CandidateId), ResumeGetDto.class),"Aferin başardın");
	//}

	
	
}
