package com.example.reservas.service;

import java.util.List;

import com.example.reservas.entity.Cliente;

public interface ClienteService {
    List<Cliente> readAll();

    Cliente create(Cliente al);

    Cliente read(int id);

    void delete(int id);

    Cliente update(Cliente al);
}
