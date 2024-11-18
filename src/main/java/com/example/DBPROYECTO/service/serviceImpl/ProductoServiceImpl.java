package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.entities.Producto;
import com.example.DBPROYECTO.repository.ProductoRepository;
import com.example.DBPROYECTO.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto findByCodigo(Long codigo){
     return productoRepository.findByCodigo(codigo);
    }
    @Override
    public void productoSave(Producto producto){
        productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> findById(Long id){
        return productoRepository.findById(id);
    }

    public Producto createProducto(Producto producto){
        return productoRepository.save(producto);
    }




}
