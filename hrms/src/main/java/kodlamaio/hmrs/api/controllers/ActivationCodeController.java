package kodlamaio.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.ActivationCodeService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.ActivationCodeAddDto;

@RestController
@RequestMapping("/api/activationcontroller")
@CrossOrigin
public class ActivationCodeController {
	
	private ActivationCodeService activationCodeService;
	@Autowired
	public ActivationCodeController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ActivationCodeAddDto activationCodeAddDto) {
		return this.activationCodeService.addActivationCode(activationCodeAddDto);
	}
	
	
}
