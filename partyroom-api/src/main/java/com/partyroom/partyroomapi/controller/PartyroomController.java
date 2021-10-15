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

import com.partyroom.partyroomapi.model.Partyroom;
import com.partyroom.partyroomapi.service.PartyroomService;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PartyroomController {

	@Autowired
	private PartyroomService partyroomService;

	@GetMapping("/all")
	public List<Partyroom> getPartyrooms() {
		return partyroomService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional <Partyroom> getPartyroom(@PathVariable("id")Integer id){
		return partyroomService.getPartyroom(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Partyroom save(@RequestBody Partyroom p) {
		return partyroomService.save(p);
		
	}
	
}
