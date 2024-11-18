package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.Proveedor;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    Proveedor createProveedor(Proveedor proveedor);

    List<Proveedor> proveedores();

    Optional<Proveedor> findById(Long id);


}
