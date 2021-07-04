package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeExperienceAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeExperienceGetDto;

@RestController
@RequestMapping("/api/resumeExperience")
public class ResumeExperienceController {
	
	private ResumeExperienceService resumeExperienceService;
	@Autowired
	public ResumeExperienceController(ResumeExperienceService resumeExperienceService) {
		super();
		this.resumeExperienceService = resumeExperienceService;
	}
	
	@GetMapping("/getAllResumeExperiences")
	public DataResult<List<ResumeExperienceGetDto>> getAll(){
		return this.resumeExperienceService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody ResumeExperienceAddDto resumeExperienceAddDto) {
		return this.resumeExperienceService.add(resumeExperienceAddDto);
	}

}
