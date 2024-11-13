package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.entities.TipoProducto;
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
@RequestMapping("/tipoproducto")
public class TipoProductoController {

    private final TipoProductoService tipoProductoService;

    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    @PostMapping("/create")
    public ResponseEntity <Object> createTipoProducto(@Valid @RequestBody TipoProducto tipoProducto, BindingResult result){



        if (tipoProductoService.findByName(tipoProducto.getNombre())!=null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El producto ya existe en la base de datos.",HttpStatus.BAD_REQUEST));
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaErrorValid(result));
        }
        try {

            tipoProductoService. creatProducto(tipoProducto);

            return ResponseEntity.status(HttpStatus.CREATED).body(tipoProducto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("La solicitud es inválida", HttpStatus.BAD_REQUEST));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }







    @GetMapping("/list")
    public ResponseEntity<Object> listarProductos(){

        List<TipoProducto> tipoProductoList = tipoProductoService.productosList();
        if (tipoProductoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("No hay productos cargados.",HttpStatus.BAD_REQUEST));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(tipoProductoList);
    }

    @GetMapping("/findbyname")
    public ResponseEntity <Object> findbyname(@Param("nombre") String nombre){

        TipoProducto tipoProducto = tipoProductoService.findByName(nombre);

        if (tipoProducto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El tipo de producto no existe en la base de datos.",HttpStatus.BAD_REQUEST));

        }
        return  ResponseEntity.status(HttpStatus.OK).body(tipoProducto);
    }
}
