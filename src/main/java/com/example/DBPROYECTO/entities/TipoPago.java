package com.example.DBPROYECTO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pago;

    public TipoPago() {
    }

    public TipoPago(Long id, String pago) {
        this.id = id;
        this.pago = pago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "TipoPago{" +
                "id=" + id +
                ", pago='" + pago + '\'' +
                '}';
    }
}
