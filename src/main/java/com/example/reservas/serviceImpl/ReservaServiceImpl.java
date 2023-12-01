package com.example.reservas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservas.entity.Reserva;
import com.example.reservas.repository.ReservaRepository;
import com.example.reservas.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository r;

    @Override
    public List<Reserva> readAll() {
        return r.findAll();
    }

    @Override
    public Reserva create(Reserva al) {
        return r.save(al);
    }

    @Override
    public Reserva read(int id) {
        return r.findById(id).get();
    }

    @Override
    public void delete(int id) {
        r.deleteById(id);
    }

    @Override
    public Reserva update(Reserva al) {
        return r.save(al);
    }
}
