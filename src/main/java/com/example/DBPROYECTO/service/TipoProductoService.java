package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.TipoProducto;

import java.util.List;

public interface TipoProductoService {
    List<TipoProducto> productosList();

    TipoProducto findByName(String nombre);

    void creatProducto(TipoProducto tipoProducto);
}
