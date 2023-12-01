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

import com.example.reservas.entity.Cliente;
import com.example.reservas.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService s;

    @GetMapping("/")
    public String get() {
        return "TODO OK";
    }

    // CREAR
    @PostMapping("/create")
    public ResponseEntity<Cliente> save(@RequestBody Cliente lib) {
        try {
            Cliente l = s.create(lib);
            return new ResponseEntity<>(l, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // LISTAR
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> list() {
        try {
            List<Cliente> list = new ArrayList<>();
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
    public ResponseEntity<Cliente> search(@PathVariable("id") int id) {
        Cliente Cliente = s.read(id);
        if (Cliente.getIdcliente() > 0) {
            return new ResponseEntity<>(Cliente, HttpStatus.OK);
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
    public ResponseEntity<Cliente> update(@RequestBody Cliente l, @PathVariable("id") int id) {
        try {
            Cliente li = s.read(id);
            if (li.getIdcliente() > 0) {
                li.setNombres(l.getNombres());
                li.setApellidos(l.getApellidos());
                li.setTelefono(l.getTelefono());
                li.setEmail(l.getEmail());

                return new ResponseEntity<>(s.create(li), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
