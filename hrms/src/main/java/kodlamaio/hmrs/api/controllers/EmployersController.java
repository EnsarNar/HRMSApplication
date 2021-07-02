package kodlamaio.hmrs.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.dtos.EmployersSelectDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService empoyerService;
	
	private EmployerDao employerDao;

	@Autowired
	public EmployersController(EmployerService empoyerService, EmployerDao employerDao) {
		super();
		this.empoyerService = empoyerService;
		this.employerDao = employerDao;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.empoyerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Employer employer) {
		return this.empoyerService.add(employer);
	}
	@PostMapping("/confirm")
	public Result confirm(@RequestParam String activationCode) {
		return this.empoyerService.confirm(activationCode);
	}
	
	@GetMapping("/selectEmployers")
	public DataResult<List<EmployersSelectDto>> getSelectEmployers(){
		List<EmployersSelectDto> employersSelectDto = new ArrayList<EmployersSelectDto>();
		List<Employer> employers= this.employerDao.findAll();
		for(Employer employer:employers) {
			employersSelectDto.add(new EmployersSelectDto(employer.getId(),employer.getId(),employer.getCompanyName()));
		};
		return new SuccessDataResult<List<EmployersSelectDto>>
		(employersSelectDto);
	};
	

}
