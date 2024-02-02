package com.selflearning.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selflearning.springboot.exception.ItemNotFoundException;
import com.selflearning.springboot.model.Library;
import com.selflearning.springboot.repository.LibraryRepository;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@GetMapping("/getAll")
	public List<Library> getBooks(){
		return libraryRepository.findAll();
	}
	@GetMapping("/get/{id}")
	public Library getById(@PathVariable Long id) {
		Library ref=new Library();
		try {
			 ref=libraryRepository.findById(id);
		}catch(Exception e) {
			throw new ItemNotFoundException(id);
		}
		return ref;
	}
	@PostMapping("/create")
	public Library createBook(@Valid @RequestBody Library lib) {
		return libraryRepository.save(lib);
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllBooks() {
		 libraryRepository.deleteAll();
	}
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable Long id) {
		libraryRepository.delete(id);
	}
	
}
