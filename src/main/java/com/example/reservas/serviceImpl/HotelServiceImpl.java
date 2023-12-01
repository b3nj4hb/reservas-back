package com.example.reservas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservas.entity.Hotel;
import com.example.reservas.repository.HotelRepository;
import com.example.reservas.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository r;

    @Override
    public List<Hotel> readAll() {
        return r.findAll();
    }

    @Override
    public Hotel create(Hotel al) {
        return r.save(al);
    }

    @Override
    public Hotel read(int id) {
        return r.findById(id).get();
    }

    @Override
    public void delete(int id) {
        r.deleteById(id);
    }

    @Override
    public Hotel update(Hotel al) {
        return r.save(al);
    }
}
