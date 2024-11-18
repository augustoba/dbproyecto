package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.dto.request.FacturaRequest;
import com.example.DBPROYECTO.entities.*;
import com.example.DBPROYECTO.repository.FacturaRepository;
import com.example.DBPROYECTO.service.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

   private final ClienteService clienteService;
   private final ProductoService productoService;
   private final TipoFacturaService tipoFacturaService;
   private final TipoPagoService tipoPagoService;
   private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(ClienteService clienteService, ProductoService productoService, TipoFacturaService tipoFacturaService, TipoPagoService tipoPagoService, FacturaRepository facturaRepository) {
        this.clienteService = clienteService;
        this.productoService = productoService;
        this.tipoFacturaService = tipoFacturaService;
        this.tipoPagoService = tipoPagoService;
        this.facturaRepository = facturaRepository;
    }

    @Transactional
    @Override
    public Factura crearFactura(FacturaRequest facturaRequest){

        Factura facturaAux = new Factura();
        Double total=0.0;

        facturaAux.setFecha(new Date());
        facturaAux.setPagado(facturaRequest.getPagado());


        Cliente cliente = clienteService.findByCuit(facturaRequest.getClienteCUIT());
        if (cliente == null){
            throw new RuntimeException("cliente no encontrado cuit : " +  facturaRequest.getClienteCUIT());
        }
        facturaAux.setCliente(cliente);
        List<Producto> productoList=new ArrayList<>();
        for (String producto : facturaRequest.getProductosListID()){
            Optional<Producto> productoAux= productoService.findById(Long.parseLong(producto));
            if (productoAux == null){
                throw new RuntimeException("producto no encontrado codigo de producto:  " + producto);
            }

            productoAux.get().setStock(productoAux.get().getStock()-1);
            productoService.productoSave(productoAux.get());
            total= total + productoAux.get().getPrecio();
            productoList.add(productoAux.get());
        }
        facturaAux.setProductos(productoList);
        facturaAux.setTotal(total);
        TipoFactura tipoFactura = tipoFacturaService.findByName(facturaRequest.getTipoFactura());
        facturaAux.setTipoFactura(tipoFactura);
        TipoPago tipoPago = tipoPagoService.findByName(facturaRequest.getTipoPago());
        facturaAux.setTipoPago(tipoPago);
        return facturaRepository.save(facturaAux);
    }

    @Override
    public List<Factura> facturaList(){
        return facturaRepository.findAll();
    }


}
