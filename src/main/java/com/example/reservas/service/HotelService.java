package com.example.reservas.service;

import java.util.List;

import com.example.reservas.entity.Hotel;

public interface HotelService {
    List<Hotel> readAll();

    Hotel create(Hotel al);

    Hotel read(int id);

    void delete(int id);

    Hotel update(Hotel al);
}
