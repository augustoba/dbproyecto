package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.entities.Producto;
import com.example.DBPROYECTO.entities.TipoProducto;
import com.example.DBPROYECTO.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.DBPROYECTO.exception.GenericException.errorRespuesta;
import static com.example.DBPROYECTO.exception.GenericException.respuestaErrorValid;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @PostMapping("/create")
    public ResponseEntity<Object> createProducto(@Valid @RequestBody Producto producto, BindingResult result){



        if (productoService.findByCodigo (producto.getCodigo())!=null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El producto ya existe en la base de datos.",HttpStatus.BAD_REQUEST));
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaErrorValid(result));
        }
        try {

            productoService.productoSave(producto);

            return ResponseEntity.status(HttpStatus.CREATED).body(producto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("La solicitud es inválida", HttpStatus.BAD_REQUEST));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }


}
