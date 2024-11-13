package com.example.DBPROYECTO.repository;


import com.example.DBPROYECTO.entities.TipoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFacturaRepository extends JpaRepository<TipoFactura,Long> {

    TipoFactura findByTipo(String tipo);


}
