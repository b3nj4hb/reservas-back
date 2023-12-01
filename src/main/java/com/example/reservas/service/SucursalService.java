package com.example.reservas.service;

import java.util.List;

import com.example.reservas.entity.Sucursal;

public interface SucursalService {
    List<Sucursal> readAll();

    Sucursal create(Sucursal al);

    Sucursal read(int id);

    void delete(int id);

    Sucursal update(Sucursal al);
}
