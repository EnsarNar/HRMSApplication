package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeEducationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeEducationAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeEducationGetDto;

@RestController
@RequestMapping("/api/resumeEducation")
@CrossOrigin
public class ResumeEducationController {
	
	private ResumeEducationService resumeEducationService;
	@Autowired
	public ResumeEducationController(ResumeEducationService resumeEducationService) {
		super();
		this.resumeEducationService = resumeEducationService;
	}
	@GetMapping("/getAllResumeEducations")
	public DataResult<List<ResumeEducationGetDto>> getAll(){
		return this.resumeEducationService.getAll();
	};
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeEducationAddDto resumeEducationAddDto) {
		return this.resumeEducationService.add(resumeEducationAddDto);
	}
	@GetMapping("/findById")
	public DataResult<List<ResumeEducationGetDto>> findById(@RequestParam int id) {
		return this.resumeEducationService.findById(id);
	};
	
	@GetMapping("/findByResumeId")
	public DataResult<List<ResumeEducationGetDto>> findByResumeId(@RequestParam int id) {
		return this.resumeEducationService.findByResumeId(id);
	};
}
