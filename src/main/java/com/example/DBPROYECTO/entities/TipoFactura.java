package com.example.DBPROYECTO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String tipo ;

    public TipoFactura() {
    }

    public TipoFactura(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoFactura{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
