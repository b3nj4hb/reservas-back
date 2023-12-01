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

import com.example.reservas.entity.Sucursal;
import com.example.reservas.service.SucursalService;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService s;

    @GetMapping("/")
    public String get() {
        return "TODO OK";
    }

    // CREAR
    @PostMapping("/create")
    public ResponseEntity<Sucursal> save(@RequestBody Sucursal lib) {
        try {
            Sucursal l = s.create(lib);
            return new ResponseEntity<>(l, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // LISTAR
    @GetMapping("/all")
    public ResponseEntity<List<Sucursal>> list() {
        try {
            List<Sucursal> list = new ArrayList<>();
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
    public ResponseEntity<Sucursal> search(@PathVariable("id") int id) {
        Sucursal Sucursal = s.read(id);
        if (Sucursal.getIdsucursal() > 0) {
            return new ResponseEntity<>(Sucursal, HttpStatus.OK);
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
    public ResponseEntity<Sucursal> update(@RequestBody Sucursal l, @PathVariable("id") int id) {
        try {
            Sucursal li = s.read(id);
            if (li.getIdsucursal() > 0) {
                li.setDireccion(l.getDireccion());
                li.setLocalidad(l.getLocalidad());
                li.setProvincia(l.getProvincia());
                li.setTelefono(l.getTelefono());

                return new ResponseEntity<>(s.create(li), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
