package com.example.reservas.service;

import java.util.List;

import com.example.reservas.entity.Reserva;

public interface ReservaService {
    List<Reserva> readAll();

    Reserva create(Reserva al);

    Reserva read(int id);

    void delete(int id);

    Reserva update(Reserva al);
}
