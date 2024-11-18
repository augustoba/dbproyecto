package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.dto.request.FacturaRequest;
import com.example.DBPROYECTO.entities.Factura;
import jakarta.transaction.Transactional;

import java.util.List;

public interface FacturaService {
    @Transactional
    Factura crearFactura(FacturaRequest facturaRequest);

    List<Factura> facturaList();
}
