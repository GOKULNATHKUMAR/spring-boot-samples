package com.selflearning.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selflearning.springboot.model.Library;
import com.selflearning.springboot.repository.LibraryRepository;

@RestController
public class LibraryController {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@GetMapping("/getall")
	public List<Library> getBooks(){
		return libraryRepository.findAll();
		
	}
	
}
