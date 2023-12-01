package com.example.reservas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservas.entity.Sucursal;
import com.example.reservas.repository.SucursalRepository;
import com.example.reservas.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository r;

    @Override
    public List<Sucursal> readAll() {
        return r.findAll();
    }

    @Override
    public Sucursal create(Sucursal al) {
        return r.save(al);
    }

    @Override
    public Sucursal read(int id) {
        return r.findById(id).get();
    }

    @Override
    public void delete(int id) {
        r.deleteById(id);
    }

    @Override
    public Sucursal update(Sucursal al) {
        return r.save(al);
    }
}
