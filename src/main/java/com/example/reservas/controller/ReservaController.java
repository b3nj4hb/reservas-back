package com.example.reservas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.entity.Reserva;
import com.example.reservas.service.ReservaService;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    @Autowired
    private ReservaService s;

    @GetMapping("/")
    public String get() {
        return "TODO OK";
    }

    // CREAR
    @PostMapping("/create")
    public ResponseEntity<Reserva> save(@RequestBody Reserva lib) {
        try {
            Reserva l = s.create(lib);
            return new ResponseEntity<>(l, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // LISTAR
    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Reserva>> list() {
        try {
            List<Reserva> list = new ArrayList<>();
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
    public ResponseEntity<Reserva> search(@PathVariable("id") int id) {
        Reserva Reserva = s.read(id);
        if (Reserva.getIdreserva() > 0) {
            return new ResponseEntity<>(Reserva, HttpStatus.OK);
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
    public ResponseEntity<Reserva> update(@RequestBody Reserva l, @PathVariable("id") int id) {
        try {
            Reserva li = s.read(id);
            if (li.getIdreserva() > 0) {
                li.setIdvuelo(l.getIdvuelo());
                li.setIdcliente(l.getIdcliente());
                li.setIdhotel(l.getIdhotel());
                li.setIdsucursal(l.getIdsucursal());

                return new ResponseEntity<>(s.create(li), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
