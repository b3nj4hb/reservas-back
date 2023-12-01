package com.example.reservas.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreserva;

    private String clase;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idvuelo", referencedColumnName = "idvuelo")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Vuelo idvuelo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Cliente idcliente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idhotel", referencedColumnName = "idhotel")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Hotel idhotel;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Sucursal idsucursal;
}