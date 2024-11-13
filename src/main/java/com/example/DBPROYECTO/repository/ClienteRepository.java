package com.example.DBPROYECTO.repository;

import com.example.DBPROYECTO.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Cliente findByCuit(String cuil);

    Cliente findByNombreAndApellido(String nombre,String apellido);
}
