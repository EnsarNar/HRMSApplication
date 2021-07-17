package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.dtos.CityDto;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {
	private CityService citySrevice;
	@Autowired
	public CityController(CityService citySrevice) {
		super();
		this.citySrevice = citySrevice;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<CityDto>> getAll(){
		
		return this.citySrevice.getAll();
	};
	
	

}
