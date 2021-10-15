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

import com.partyroom.partyroomapi.model.Admin;
import com.partyroom.partyroomapi.service.AdminService;


@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/all")
	public List<Admin> getAdmins() {
		return adminService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional <Admin> getAdmin(@PathVariable("id")Integer id){
		return adminService.getAdmin(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Admin save(@RequestBody Admin p) {
		return adminService.save(p);
		
	}
	
}