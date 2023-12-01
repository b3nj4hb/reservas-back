package com.example.reservas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.entity.Vuelo;
import com.example.reservas.service.VueloService;

@RestController
@RequestMapping("/api/vuelo")
public class VueloController {
    @Autowired
    private VueloService s;

    @GetMapping("/")
    public String get() {
        return "TODO OK";
    }

    // CREAR
    @PostMapping("/create")
    public ResponseEntity<Vuelo> save(@RequestBody Vuelo lib) {
        try {
            Vuelo l = s.create(lib);
            return new ResponseEntity<>(l, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // LISTAR
    @GetMapping("/all")
    public ResponseEntity<List<Vuelo>> list() {
        try {
            List<Vuelo> list = new ArrayList<>();
            list = s.readAll();
            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // BUSCAR {ID}
    @GetMapping("/read/{id}")
    public ResponseEntity<Vuelo> search(@PathVariable("id") int id) {
        Vuelo Vuelo = s.read(id);
        if (Vuelo.getIdvuelo() > 0) {
            return new ResponseEntity<>(Vuelo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ELIMINAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            s.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ACTUALIZAR {ID}
    @PutMapping("/update/{id}")
    public ResponseEntity<Vuelo> update(@RequestBody Vuelo l, @PathVariable("id") int id) {
        try {
            Vuelo li = s.read(id);
            if (li.getIdvuelo() > 0) {
                li.setFecha_salida(l.getFecha_salida());
                li.setHora_salida(l.getHora_salida());
                li.setFecha_llegada(l.getFecha_llegada());
                li.setHora_llegada(l.getHora_llegada());
                li.setOrigen(l.getOrigen());
                li.setDestino(l.getDestino());
                li.setNumero_plazas_totales(l.getNumero_plazas_totales());

                return new ResponseEntity<>(s.create(li), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
