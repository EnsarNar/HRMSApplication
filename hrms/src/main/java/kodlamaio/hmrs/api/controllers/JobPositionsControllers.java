package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;
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
	
	@RequestMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionsService.getAll();
	};
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionsService.add(jobPosition);
	}
	
}
