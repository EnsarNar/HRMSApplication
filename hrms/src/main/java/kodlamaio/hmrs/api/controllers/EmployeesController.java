package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	};
	
	@PostMapping("/add")
	Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}

	
	
}
