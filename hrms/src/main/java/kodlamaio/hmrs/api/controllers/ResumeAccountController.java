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
import kodlamaio.hmrs.entities.dtos.ResumeAccountDto;

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
	public Result add(@RequestBody ResumeAccountDto resumeAccountDto) {
		return this.resumeAccountService.add(resumeAccountDto);
	}
	@GetMapping("/getAll")
	public DataResult<List<ResumeAccountDto>> getAll(){
		return this.resumeAccountService.getAll();
	}
	@GetMapping("/findById")
	public DataResult<List<ResumeAccountDto>> findById(int id){
		return this.resumeAccountService.findById(id);
	};
	@GetMapping("/findAllByResumeId")
	public DataResult<List<ResumeAccountDto>> findByResumeId(int id){
		return this.resumeAccountService.findAllByResumeId(id);
	};
	

}
