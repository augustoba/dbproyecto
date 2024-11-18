package com.example.DBPROYECTO.repository;

import com.example.DBPROYECTO.entities.Producto;
import com.example.DBPROYECTO.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

   List<Producto> findByNombre(String nombre);
   @Query("SELECT p FROM Producto p WHERE p.codigo = :codigo AND p.stock > 0")
   Producto findByCodigo(Long codigo);

   @Query("SELECT p FROM Producto p WHERE p.proveedor.nombre = :nombre")
   List<Producto> findByProveedor_Nombre(String nombre);

   @Query("SELECT p FROM Producto p WHERE p.proveedor.cbu = :cbu")
   List<Producto> findByProveedor_Cbu(String cbu);
}
