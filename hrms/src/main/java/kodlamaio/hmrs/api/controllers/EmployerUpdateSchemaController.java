package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployerUpdateSchemaService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.EmployerUpdateSchemaAddDto;
import kodlamaio.hmrs.entities.dtos.EmployerUpdateSchemaGetDto;

@RestController
@RequestMapping("/api/employerUpdateSchemas")
@CrossOrigin
public class EmployerUpdateSchemaController {

	private EmployerUpdateSchemaService employerUpdateSchemaService;
	@Autowired
	public EmployerUpdateSchemaController(EmployerUpdateSchemaService employerUpdateSchemaService) {
		super();
		this.employerUpdateSchemaService = employerUpdateSchemaService;
	}	
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<EmployerUpdateSchemaGetDto>> getAll(){
		return this.employerUpdateSchemaService.getAll();
	};
	@PostMapping("/updateEmail")
	public Result updateEmail(@RequestParam String email, int id) {
		return this.employerUpdateSchemaService.updateEmail(email, id);
	};
	@PostMapping("/updatePhone")
	public Result updatePhone(@RequestParam String phone, int id) {
		return this.employerUpdateSchemaService.updateEmail(phone, id);
	};
	@PostMapping("/updateWebAdress")
	public Result updateWebAdress(@RequestParam String webAdress, int id) {
		return this.employerUpdateSchemaService.updateEmail(webAdress, id);
	};
	@PostMapping("/updatePassword")
	public Result updateWebAdress(@RequestParam String password, String passwordRepeat, int id) {
		return this.employerUpdateSchemaService.updatePassword(password, passwordRepeat,id);
	};	
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUpdateSchemaAddDto employerUpdateSchemaAddDto) {
		return this.employerUpdateSchemaService.add(employerUpdateSchemaAddDto);
	};
	
	
	
	
}
