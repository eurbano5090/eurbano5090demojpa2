package com.openbootcamp.demojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openbootcamp.demojpa.models.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

}
