package com.ford.afd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ford.afd.model.Catagory;

public interface CatagoryRepository extends JpaRepository<Catagory, Long> {
}
