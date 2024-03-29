package com.selflearning.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selflearning.springboot.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	Library findById(Long id);

}
