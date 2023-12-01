package com.example.reservas.service;

import java.util.List;

import com.example.reservas.entity.Vuelo;

public interface VueloService {
    List<Vuelo> readAll();

    Vuelo create(Vuelo al);

    Vuelo read(int id);

    void delete(int id);

    Vuelo update(Vuelo al);
}
