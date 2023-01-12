package com.openbootcamp.demojpa.controllers;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openbootcamp.demojpa.models.Laptop;
import com.openbootcamp.demojpa.repositories.LaptopRepository;

@RestController
@RequestMapping("/")
public class LaptopController {

	private final Logger log = LoggerFactory.getLogger(LaptopController.class);

	private LaptopRepository laptoprepository;

	public LaptopController(LaptopRepository laptoprepository) {
		super();
		this.laptoprepository = laptoprepository;
	}

	@GetMapping("/api/laptops")
	public List<Laptop> finAll() {
		return laptoprepository.findAll();

	}

	@GetMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> findById(@PathVariable Long id) {
		Optional<Laptop> oplaptop = laptoprepository.findById(id);
		// return opbook.orElse(null);
		if (oplaptop.isPresent())
			return ResponseEntity.ok(oplaptop.get());
		else
			return ResponseEntity.notFound().build();
	}
	// return
	// opbook.map(ResponseEntity:ok).orElse(()->ResponseEntity.notFound().build());

	@PostMapping("/api/laptops")
	public Laptop crear(@RequestBody Laptop laptop) {
		return laptoprepository.save(laptop);

	}

	@PutMapping("/api/laptops")
	public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

		if (laptop.getId() != null) {
			log.warn("trying to update a non existent laptops ");
			return ResponseEntity.badRequest().build();
		}
		if (!laptoprepository.existsById(laptop.getId())) {
			log.warn("trying to update a non existent laptops ");
			return ResponseEntity.notFound().build();
		}
		Laptop result = laptoprepository.save(laptop);
		return ResponseEntity.ok(result);

	}

	// @ApiIgnore
	@DeleteMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> delete(@PathVariable Long id) {
		if (!laptoprepository.existsById(id)) {
			log.warn("trying to delete a non existent laptops ");
			return ResponseEntity.notFound().build();
		}
		laptoprepository.deleteById(id);
		return ResponseEntity.noContent().build();

	}

	// @ApiIgnore
	@DeleteMapping("/api/laptops")
	public ResponseEntity<Laptop> deleteAll() {
		log.info("Rest request for deleting all laptops");
		laptoprepository.deleteAll();
		return ResponseEntity.noContent().build();

	}
}
