package com.educaciontit.digitalers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaciontit.digitalers.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByUserId(Long id);
}
