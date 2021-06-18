package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hmrs.entities.dtos.JobAdvertisementGetDto;

@RequestMapping("/api/jobAdvertisement")
@RestController
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementGetDto>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisementGetDto>> findByIsActiveAndEmployer_CompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(companyName);
	}
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisementGetDto>> getAllSorted(){
		return this.jobAdvertisementService.getAllSorted();
	}
	@GetMapping("/getAllActiveAdvertisements")
	public DataResult<List<JobAdvertisementGetDto>> findByIsActive(){
		return this.jobAdvertisementService.findByIsActive();
	}
}
