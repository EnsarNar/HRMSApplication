package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.FavoriteForCandidateService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.dtos.FavoriteForCandidateDto;

@RestController
@RequestMapping("/api/favoriteForCandidate")
@CrossOrigin
public class FavoritesForCandidatesController {

	private FavoriteForCandidateService favoriteForCandidateService;
	@Autowired
	public FavoritesForCandidatesController(FavoriteForCandidateService favoriteForCandidateService) {
		super();
		this.favoriteForCandidateService = favoriteForCandidateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<FavoriteForCandidateDto>> getAll(){
		return this.favoriteForCandidateService.getAll();
	};
	
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteForCandidateDto favoriteForCandidateDto) {
		return this.favoriteForCandidateService.add(favoriteForCandidateDto);
	};
	
	
	
}
