package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployersActivationByEmployeesService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

@RestController
@RequestMapping("/api/adminactivation")
public class EmployersActivationByEmployeesController {
	
	private EmployersActivationByEmployeesService employersActivationByEmployeesService;
	@Autowired
	public EmployersActivationByEmployeesController(
			EmployersActivationByEmployeesService employersActivationByEmployeesService) {
		super();
		this.employersActivationByEmployeesService = employersActivationByEmployeesService;
	}
	//SIMULATED SIMULATED SIMULATED SIMULATED
	@PostMapping("/verify")
	public Result verifyEmployer(Employer employer) {
		return this.employersActivationByEmployeesService.confirmEmployer(employer);
	}

}
