package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.WorkTimeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.WorkTimeDto;

@RestController
@RequestMapping("/api/workTime")
@CrossOrigin
public class WorkTimeController {

	private WorkTimeService workTimeService;
	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkTimeDto>> getAll(){
		return this.workTimeService.getAll();
	};
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkTimeDto workTimeDto) {
		return this.workTimeService.add(workTimeDto);
	};
}
