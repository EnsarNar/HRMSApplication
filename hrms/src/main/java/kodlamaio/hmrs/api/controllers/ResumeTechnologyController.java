package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeTechnologyService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeTechnologyAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeTechnologyGetDto;

@RestController
@RequestMapping("/api/resumeTechnology")
@CrossOrigin
public class ResumeTechnologyController {
	private ResumeTechnologyService resumeTechnologyService;
	@Autowired
	public ResumeTechnologyController(ResumeTechnologyService resumeTechnologyService) {
		super();
		this.resumeTechnologyService = resumeTechnologyService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<ResumeTechnologyGetDto>> getAll(){
		return this.resumeTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(ResumeTechnologyAddDto resumeTechnologyAddDto) {
		return this.resumeTechnologyService.add(resumeTechnologyAddDto);
	}
	@GetMapping("/findById")
	public DataResult<List<ResumeTechnologyGetDto>> findById(int id){
		return this.resumeTechnologyService.findById(id);
	};
	@GetMapping("/findAllByResumeId")
	public DataResult<List<ResumeTechnologyGetDto>> findAllByResumeId(int id){
		return this.resumeTechnologyService.findAllByResumeId(id);
	};
	@PutMapping("/update")
	public Result update(ResumeTechnologyAddDto resumeTechnologyAddDto) {
		return this.resumeTechnologyService.update(resumeTechnologyAddDto);
	};
}
