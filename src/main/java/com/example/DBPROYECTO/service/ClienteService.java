package com.example.DBPROYECTO.service;

import com.example.DBPROYECTO.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    void createClient(Cliente cliente);

    List<Cliente> clientes();

    Optional<Cliente> findById(Long id);

    Cliente findByNameAndLastName(String nombre, String apellido);
}
