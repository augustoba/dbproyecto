package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.entities.Proveedor;
import com.example.DBPROYECTO.service.serviceImpl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorServiceImpl proveedorService = new ProveedorServiceImpl();

    @PostMapping("/create")
    public Boolean createProveedor(@RequestBody Proveedor proveedor){

        try {
            return  proveedorService.createProvider(proveedor);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @GetMapping("/list")
    public List<Proveedor> listarProveedores(){

    return proveedorService.proveedores();
}

}
