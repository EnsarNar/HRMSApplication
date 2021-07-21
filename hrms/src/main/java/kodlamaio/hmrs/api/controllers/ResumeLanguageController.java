package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeLanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeLanguageAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeLanguageGetDto;

@RestController
@RequestMapping("/api/resumeLanguage")
@CrossOrigin
public class ResumeLanguageController {

	private ResumeLanguageService resumeLanguageService;
	@Autowired
	public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
		super();
		this.resumeLanguageService =resumeLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ResumeLanguageGetDto>> getAll(){
		return this.resumeLanguageService.getAll();
	};
	@PostMapping("/add")
	public Result add(ResumeLanguageAddDto resumeLanguageAddDto) {
		return this.resumeLanguageService.add(resumeLanguageAddDto);
	}
	@GetMapping("/findById")
	public DataResult<List<ResumeLanguageGetDto>> findById(int id){
		return this.resumeLanguageService.findById(id);
	};
	
	@GetMapping("/findAllByResumeId")
	public DataResult<List<ResumeLanguageGetDto>> findAllByResumeId(int id){
		return this.resumeLanguageService.findAllByResumeId(id);
	};
}
