package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.entities.Proveedor;
import com.example.DBPROYECTO.repository.ProveedorRepository;
import com.example.DBPROYECTO.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor createProveedor(Proveedor proveedor){
        Proveedor proveedorAux ;
        proveedorAux=proveedorRepository.findByCuit(proveedor.getCuit());
        if ( proveedorAux != null){
         throw new RuntimeException("El proveedor ya existe con este cuit : " +  proveedor.getCuit());
        }
     return  proveedorRepository.save(proveedor) ;


    }
    @Override
    public List<Proveedor> proveedores(){
        return  proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id){
        return  proveedorRepository.findById(id);
    }

}