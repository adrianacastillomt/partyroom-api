package com.partyroom.partyroomapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.partyroom.partyroomapi.model.Score;
import com.partyroom.partyroomapi.service.ScoreService;


@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@GetMapping("/all")
	public List<Score> getScores() {
		return scoreService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional <Score> getScore(@PathVariable("id")Integer id){
		return scoreService.getScore(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Score save(@RequestBody Score p) {
		return scoreService.save(p);
		
	}
	
}