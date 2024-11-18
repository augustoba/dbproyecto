package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.Mapper.ClienteMapper;
import com.example.DBPROYECTO.dto.request.ClienteRequest;
import com.example.DBPROYECTO.dto.request.FacturaRequest;
import com.example.DBPROYECTO.entities.Factura;
import com.example.DBPROYECTO.service.FacturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.DBPROYECTO.exception.GenericException.errorRespuesta;
import static com.example.DBPROYECTO.exception.GenericException.respuestaErrorValid;

@RestController
@RequestMapping("/factura")
public class FacturaController {

   private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createFactura(@Valid @RequestBody FacturaRequest facturaRequest, BindingResult result){


        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaErrorValid(result));
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( facturaService.crearFactura(facturaRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("La solicitud es inválida", HttpStatus.BAD_REQUEST));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listarFactura(){
        List<Factura> facturaList = facturaService.facturaList();

       if (facturaList.isEmpty()){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("No hay facturas cargadas.",HttpStatus.BAD_REQUEST));
       }
        return  ResponseEntity.status(HttpStatus.OK).body(facturaList);
    }
}
