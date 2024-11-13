package com.example.DBPROYECTO.repository;

import com.example.DBPROYECTO.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {

    Proveedor findByCuit(Long cuil);
}
