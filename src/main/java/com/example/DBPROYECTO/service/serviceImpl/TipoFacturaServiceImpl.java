package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.entities.TipoFactura;
import com.example.DBPROYECTO.repository.TipoFacturaRepository;
import com.example.DBPROYECTO.service.TipoFacturaService;
import org.springframework.stereotype.Service;

@Service
public class TipoFacturaServiceImpl implements TipoFacturaService {

   private final  TipoFacturaRepository tipoFacturaRepository;

    public TipoFacturaServiceImpl(TipoFacturaRepository tipoFacturaRepository) {
        this.tipoFacturaRepository = tipoFacturaRepository;
    }

    @Override
    public TipoFactura findByName(String name){
        return  tipoFacturaRepository.findByTipo(name);
    }
}
