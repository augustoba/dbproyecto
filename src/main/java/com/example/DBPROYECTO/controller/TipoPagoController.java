package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.entities.TipoPago;
import com.example.DBPROYECTO.entities.TipoProducto;
import com.example.DBPROYECTO.service.TipoPagoService;
import com.example.DBPROYECTO.service.TipoProductoService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.DBPROYECTO.exception.GenericException.errorRespuesta;
import static com.example.DBPROYECTO.exception.GenericException.respuestaErrorValid;

@RestController
@RequestMapping("/tipopago")
public class TipoPagoController {

    private final TipoPagoService tipoPagoService;

    public TipoPagoController(TipoPagoService tipoPagoService) {
        this.tipoPagoService = tipoPagoService;
    }


    @PostMapping("/create")
    public ResponseEntity <Object> createTipoPago(@Valid @RequestBody TipoPago tipoPago, BindingResult result){


        if (tipoPagoService.findByName(tipoPago.getPago())!=null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El tipo de pago ya existe en la base de datos.",HttpStatus.BAD_REQUEST));
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaErrorValid(result));
        }
        try {

            tipoPagoService.createTipoPago(tipoPago);

            return ResponseEntity.status(HttpStatus.CREATED).body(tipoPago);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("La solicitud es inválida", HttpStatus.BAD_REQUEST));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }






    @GetMapping("/list")
    public ResponseEntity<Object> listarPagoss(){

        List<TipoPago> tipoPagoList = tipoPagoService.tipoPagoList();
        if (tipoPagoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("No hay pagos cargados.",HttpStatus.BAD_REQUEST));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(tipoPagoList);
    }

    @GetMapping("/findbyname")
    public ResponseEntity <Object> findbyname(@Param("nombre") String nombre){

        TipoPago tipoPago  = tipoPagoService.findByName(nombre);

        if (tipoPago == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El tipo de pago no existe en la base de datos.",HttpStatus.BAD_REQUEST));

        }
        return  ResponseEntity.status(HttpStatus.OK).body(tipoPago);
    }



}
