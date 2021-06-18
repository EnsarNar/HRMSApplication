package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.JobPositionAddDto;
import kodlamaio.hmrs.entities.dtos.JobPositionGetDto;
//BURADA DA FRONTEND KISMI İLE SENKRONİZE ÇALIŞIYORUZ ORADAKİ
//EKLEME SİLME CRUD OPERASYONLARINI BURADAN KARŞILIYORUZ
@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsControllers {
	
	private JobPositionService jobPositionsService;
	@Autowired
	public JobPositionsControllers(JobPositionService jobPositionsService) {
		
		this.jobPositionsService = jobPositionsService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<JobPositionGetDto>> getAll(){
		return this.jobPositionsService.getAll();
		};
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPositionAddDto jobPositionAddDto) {
		return this.jobPositionsService.add(jobPositionAddDto);
	}
	
}
