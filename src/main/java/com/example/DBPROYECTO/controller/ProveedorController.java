package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.entities.Cliente;
import com.example.DBPROYECTO.entities.Proveedor;
import com.example.DBPROYECTO.service.serviceImpl.ProveedorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.DBPROYECTO.exception.GenericException.errorRespuesta;
import static com.example.DBPROYECTO.exception.GenericException.respuestaErrorValid;


@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorServiceImpl proveedorService = new ProveedorServiceImpl();

    @PostMapping("/create")
    public ResponseEntity<Object>createProveedor(@Valid  @RequestBody Proveedor proveedor , BindingResult result){

        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaErrorValid(result));
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.createProveedor(proveedor));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("La solicitud es inválida", HttpStatus.BAD_REQUEST));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listarProveedores(){
        List<Proveedor> proveedorList = proveedorService.proveedores();

        if (proveedorList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("No hay proveedores cargados.",HttpStatus.BAD_REQUEST));
        }
        return  ResponseEntity.status(HttpStatus.OK).body(proveedorList);
}

    @GetMapping("/byid")
    public ResponseEntity<Object> proveedorBYId(@Param("id") Long id){

        Optional<Proveedor> proveedorAux = proveedorService.findById(id);


        return proveedorAux.<ResponseEntity<Object>>map(proveedor ->
                ResponseEntity.status(HttpStatus.OK).body(proveedor)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("No se encontro proveedor con ese id ." +
                        id, HttpStatus.BAD_REQUEST)));

    }

}
