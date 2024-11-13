package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.TipoPago;

import java.util.List;

public interface TipoPagoService {
    List<TipoPago> tipoPagoList();

    TipoPago findByName(String pago);

     void createTipoPago(TipoPago pago);
}
