package com.mvol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvol.entities.Vol;
import com.mvol.service.IVolService;

@RestController
public class VolController {

	@Autowired
	IVolService volService;
	
	@GetMapping("/vols")
	public List<Vol> findAll() {
		return volService.findAll();
	}

	@GetMapping("/vols/{idVol}")
	public Vol findOne(@PathVariable("idVol") Long id) {
		return volService.findOne(id);
	}

	@PostMapping("/vols")
	public Vol save(@RequestBody Vol vol) {
		return volService.save(vol);
	}
	
	@DeleteMapping("/vols/{idVol}")
	public void delete(@PathVariable("idVol") Long id) {
		volService.delete(id);
	}
}
