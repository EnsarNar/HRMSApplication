package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.LanguageAddDto;
import kodlamaio.hmrs.entities.dtos.LanguageGetDto;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageService;
	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LanguageGetDto>> getAll(){
		return this.languageService.getAll();
	};
		
	@PostMapping("/add")
	public Result add(@RequestBody LanguageAddDto languageAddDto) {
		return this.languageService.add(languageAddDto);
	};
	@GetMapping("/getById")
	public DataResult<List<LanguageGetDto>> getById(int id){
		return this.languageService.getById(id);
	};
	
}
