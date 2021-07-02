package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.WorkTypeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.WorkTypeDto;

@RestController
@RequestMapping("/api/workType")
@CrossOrigin
public class WorkTypeController {
	private WorkTypeService workTypeService;
	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkTypeDto>> getAll(){
		return this.workTypeService.getAll();
	};
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkTypeDto workTypeDto) {
		return this.workTypeService.add(workTypeDto);
	};
}
