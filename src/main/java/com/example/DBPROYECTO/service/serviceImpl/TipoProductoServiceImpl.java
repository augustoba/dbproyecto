package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.entities.TipoProducto;
import com.example.DBPROYECTO.repository.TipoProductoRepository;
import com.example.DBPROYECTO.service.TipoProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    private final TipoProductoRepository  tipoProductoRepository;

    public TipoProductoServiceImpl(TipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }

    @Override
    public List<TipoProducto> productosList(){
        return tipoProductoRepository.findAll();
    }
    @Override
    public TipoProducto findByName(String nombre){
        return tipoProductoRepository.findByNombre(nombre);
    }


    @Override
    public void creatProducto(TipoProducto tipoProducto){
         tipoProductoRepository.save(tipoProducto);
    }


}
