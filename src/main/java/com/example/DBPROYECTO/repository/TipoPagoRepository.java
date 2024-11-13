package com.example.DBPROYECTO.repository;


import com.example.DBPROYECTO.entities.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago,Long> {

    @Query("SELECT tp FROM TipoPago tp WHERE pago = :pago")
    TipoPago findPago(@Param("pago") String pago);
}
