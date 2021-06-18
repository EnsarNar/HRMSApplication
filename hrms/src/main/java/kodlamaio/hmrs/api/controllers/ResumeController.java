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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeGetDto;

@RestController
@RequestMapping("api/resume")
@CrossOrigin
public class ResumeController {
	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<ResumeGetDto>> getAll() {
		return this.resumeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeAddDto resumeDto) {
		return this.resumeService.add(resumeDto);
		
	}
	
	@PostMapping("/addPhoto")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int id) {
		return this.resumeService.saveImage(file, id);
	};
	
}
