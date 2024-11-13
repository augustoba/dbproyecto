package com.example.DBPROYECTO.repository;

import com.example.DBPROYECTO.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {

    @Query("SELECT f FROM Factura f WHERE f.cliente.nombre = :nombre AND f.cliente.apellido = :apellido ORDER BY f.fecha DESC")
    List<Factura> findClient(@Param("nombre") String nombre, @Param("apellido") String apellido);

    @Query("SELECT f FROM Factura f WHERE f.cliente.cuit = :cuit ORDER BY f.fecha DESC")
    List<Factura> findClientCuit(@Param("cuit") String cuit);


}
