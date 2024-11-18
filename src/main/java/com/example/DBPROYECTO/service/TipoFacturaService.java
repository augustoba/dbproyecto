package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.TipoFactura;

public interface TipoFacturaService {
    TipoFactura findByName(String name);
}
