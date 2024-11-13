package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.entities.TipoPago;
import com.example.DBPROYECTO.repository.TipoPagoRepository;
import com.example.DBPROYECTO.service.TipoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {

    private final TipoPagoRepository tipoPagoRepository;

    public TipoPagoServiceImpl(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }

    @Override
    public List<TipoPago> tipoPagoList(){
        return tipoPagoRepository.findAll();
    }
    @Override
    public TipoPago findByName(String pago){
        return tipoPagoRepository.findPago(pago);
    }

    @Override
    public void createTipoPago(TipoPago pago){
         tipoPagoRepository.save(pago);
    }
}
