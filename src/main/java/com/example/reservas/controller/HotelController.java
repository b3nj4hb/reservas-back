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

import com.example.reservas.entity.Hotel;
import com.example.reservas.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private HotelService s;

    @GetMapping("/")
    public String get() {
        return "TODO OK";
    }

    // CREAR
    @PostMapping("/create")
    public ResponseEntity<Hotel> save(@RequestBody Hotel lib) {
        try {
            Hotel l = s.create(lib);
            return new ResponseEntity<>(l, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // LISTAR
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> list() {
        try {
            List<Hotel> list = new ArrayList<>();
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
    public ResponseEntity<Hotel> search(@PathVariable("id") int id) {
        Hotel Hotel = s.read(id);
        if (Hotel.getIdhotel() > 0) {
            return new ResponseEntity<>(Hotel, HttpStatus.OK);
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
    public ResponseEntity<Hotel> update(@RequestBody Hotel l, @PathVariable("id") int id) {
        try {
            Hotel li = s.read(id);
            if (li.getIdhotel() > 0) {
                li.setNombre(l.getNombre());
                li.setDireccion(l.getDireccion());
                li.setLocalidad(l.getLocalidad());
                li.setProvincia(l.getProvincia());
                li.setTelefono(l.getTelefono());
                li.setNumero_estrellas(l.getNumero_estrellas());

                return new ResponseEntity<>(s.create(li), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
