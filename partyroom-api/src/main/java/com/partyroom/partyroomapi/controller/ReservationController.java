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

import com.partyroom.partyroomapi.model.Reservation;
import com.partyroom.partyroomapi.service.ReservationService;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/all")
	public List<Reservation> getReservations() {
		return reservationService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional <Reservation> getReservation(@PathVariable("id")Integer id){
		return reservationService.getReservation(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation save(@RequestBody Reservation p) {
		return reservationService.save(p);
		
	}
	
}