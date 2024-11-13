package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    Boolean createProvider(Proveedor proveedor);

    List<Proveedor> proveedores();

    Optional<Proveedor> findById(Long id);
}
