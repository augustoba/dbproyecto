package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.Producto;

import java.util.Optional;

public interface ProductoService {

    Producto findByCodigo(Long codigo);

    void productoSave(Producto producto);

    Optional<Producto> findById(Long id);
}
