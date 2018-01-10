package com.ford.afd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ford.afd.model.Mapping;

public interface MappingRepository extends JpaRepository<Mapping, Long> {
}
