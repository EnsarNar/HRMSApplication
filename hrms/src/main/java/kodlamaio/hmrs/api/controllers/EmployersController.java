package kodlamaio.hmrs.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import kodlamaio.hmrs.entities.dtos.EmployerAddDto;
import kodlamaio.hmrs.entities.dtos.EmployerGetDto;
import kodlamaio.hmrs.entities.dtos.EmployersSelectDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;
	private EmployerDao employerDao;

	@Autowired
	public EmployersController(EmployerService employerService,EmployerDao employerDao) {
		super();
		this.employerService = employerService;
		this.employerDao = employerDao;
	
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EmployerAddDto employerAddDto) {
		return this.employerService.add(employerAddDto);
	}
	@PostMapping("/confirm")
	public Result confirm(@RequestParam String activationCode) {
		return this.employerService.confirm(activationCode);
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

	@GetMapping("/getById")
	public DataResult<List<EmployerGetDto>> getAllById(int id){
		return this.employerService.getAllById(id);
	}
	@PutMapping("/updateEmail")
	public Result updateEmail(@RequestParam String email,@RequestParam int id) {
		return this.employerService.updateEmail(email, id);
	}
	@PutMapping("/updatePassword")
	public Result updatePassword(String password, String passwordRepeat, int id) {
		return this.employerService.updatePassword(password, passwordRepeat, id);
	};
	@PutMapping("/updatePhone")
	public Result updatePassword(String phone, int id) {
		return this.employerService.updatePhone(phone,id);
	};
	@PutMapping("/updateWebAdress")
	public Result updateWebAdress(String webAdress,int id) {
		return this.employerService.updateWebAdress(webAdress, id);
	};

}
