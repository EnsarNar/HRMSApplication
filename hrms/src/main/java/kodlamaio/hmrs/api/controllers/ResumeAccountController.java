package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ResumeAccountService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ResumeAccountAddDto;
import kodlamaio.hmrs.entities.dtos.ResumeAccountGetDto;

@RequestMapping("/api/resumeAccount")
@RestController
@CrossOrigin
public class ResumeAccountController {
	private ResumeAccountService resumeAccountService;
	@Autowired
	public ResumeAccountController(ResumeAccountService resumeAccountService) {
		super();
		this.resumeAccountService = resumeAccountService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeAccountAddDto resumeAccountDto) {
		return this.resumeAccountService.add(resumeAccountDto);
	}
	@GetMapping("/getAll")
	public DataResult<List<ResumeAccountGetDto>> getAll(){
		return this.resumeAccountService.getAll();
	}
	@GetMapping("/findById")
	public DataResult<List<ResumeAccountGetDto>> findById(int id){
		return this.resumeAccountService.findById(id);
	};
	@GetMapping("/findAllByResumeId")
	public DataResult<List<ResumeAccountGetDto>> findByResumeId(int id){
		return this.resumeAccountService.findAllByResumeId(id);
	};
	

}
