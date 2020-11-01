package com.example.statusnf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.statusnf.domain.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>, StatusRepositoryCustom {
	
	public Optional<Status> findFirstByOrderByTimestampAsc();
	
}