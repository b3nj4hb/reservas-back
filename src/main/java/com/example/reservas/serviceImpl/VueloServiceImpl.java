package com.example.reservas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservas.entity.Vuelo;
import com.example.reservas.repository.VueloRepository;
import com.example.reservas.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository r;

    @Override
    public List<Vuelo> readAll() {
        return r.findAll();
    }

    @Override
    public Vuelo create(Vuelo al) {
        return r.save(al);
    }

    @Override
    public Vuelo read(int id) {
        return r.findById(id).get();
    }

    @Override
    public void delete(int id) {
        r.deleteById(id);
    }

    @Override
    public Vuelo update(Vuelo al) {
        return r.save(al);
    }
}
