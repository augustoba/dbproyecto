package com.example.DBPROYECTO.repository;


import com.example.DBPROYECTO.entities.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto,Long> {

    TipoProducto findByNombre(String nombre);


}
