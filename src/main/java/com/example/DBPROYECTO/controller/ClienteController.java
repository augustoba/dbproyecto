package com.example.DBPROYECTO.controller;

import com.example.DBPROYECTO.Mapper.ClienteMapper;
import com.example.DBPROYECTO.entities.Cliente;
import com.example.DBPROYECTO.dto.request.ClienteRequest;
import com.example.DBPROYECTO.service.serviceImpl.ClienteServiceImpl;
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
@RequestMapping("/cliente")
public class ClienteController {


    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/create")
    public ResponseEntity <Object> createCliente(@Valid @RequestBody ClienteRequest clienteRequest, BindingResult result){



        if (clienteService.findByNameAndLastName(clienteRequest.getNombre(),clienteRequest.getApellido())!=null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El cliente ya existe en la base de datos.",HttpStatus.BAD_REQUEST));
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaErrorValid(result));
        }
        try {

            clienteService.createClient(ClienteMapper.INSTANCE.toEntity(clienteRequest));

            return ResponseEntity.status(HttpStatus.CREATED).body(clienteRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("La solicitud es inválida", HttpStatus.BAD_REQUEST));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/list")
    public ResponseEntity <Object>listarClientes(){

        List<Cliente> clienteList = clienteService.clientes();
        if (clienteList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("No hay clientes cargados.",HttpStatus.BAD_REQUEST));
        }

        return  ResponseEntity.status(HttpStatus.OK).body(clienteList);
    }

    @GetMapping("/findbyname")
    public ResponseEntity <Object> findbyname(@Param("nombre") String nombre, @Param("apellido") String apellido){

        Cliente cliente = clienteService.findByNameAndLastName(nombre,apellido);

        if (cliente == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta("El cliente no existe en la base de datos.",HttpStatus.BAD_REQUEST));

        }
        return  ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

}
