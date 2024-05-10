package com.example.lab6_20190271.Repository;

import com.example.lab6_20190271.Entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
    @Query(value = "select * from Technician",
            nativeQuery = true)
    List<Technician> lista(String nombre);


}
