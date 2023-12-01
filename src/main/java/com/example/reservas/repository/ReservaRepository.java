package com.example.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reservas.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}