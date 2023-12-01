package com.example.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reservas.entity.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}