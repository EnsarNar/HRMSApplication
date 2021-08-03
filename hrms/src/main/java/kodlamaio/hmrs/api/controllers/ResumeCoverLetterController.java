package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeCoverLetterAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeCoverLetterGetDto;

@RestController
@RequestMapping("api/resumeCoverLetter")
@CrossOrigin
public class ResumeCoverLetterController {
	private ResumeCoverLetterService resumeCoverLetterService;
	@Autowired
	public ResumeCoverLetterController(ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeCoverLetterService = resumeCoverLetterService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ResumeCoverLetterGetDto>> getAll(){
		return this.resumeCoverLetterService.getAll();
	};
	@PostMapping("/add")
	public Result add(ResumeCoverLetterAddDto resumeCoverLetterAddDto) {
		return this.resumeCoverLetterService.add(resumeCoverLetterAddDto);
	};
	
}
