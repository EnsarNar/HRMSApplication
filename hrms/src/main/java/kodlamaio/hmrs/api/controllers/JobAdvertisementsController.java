package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@DeleteMapping("/delte")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	@GetMapping("/getActiveJobAdvertisements")
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive){
		return this.jobAdvertisementService.findByIsActive(true);
	}
	@GetMapping("/getActiveJobAdvertisementsOrderedByDate")
	public DataResult<List<JobAdvertisement>> findByIsActiveOrderByApplicationDeadline(boolean isActive){
		return this.jobAdvertisementService.findByIsActiveOrderByApplicationDeadline(true);
	}
	@GetMapping("/getActiveJobAdvertisementsWithCompanyName")
	public DataResult<List<JobAdvertisement>>findByIsActiveAndEmployer_CompanyName(boolean status, String companyName){
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(true, companyName);
	}

}
