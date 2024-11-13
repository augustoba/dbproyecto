package com.example.DBPROYECTO.dto.Response;

import com.example.DBPROYECTO.entities.TipoFactura;
import com.example.DBPROYECTO.entities.TipoPago;

import java.util.Date;
import java.util.List;

public class FacturaResponseDTO {

    private Long id;

    private Boolean pagado;

    private Date fecha;

    private Double total;

    private TipoFactura tipoFactura;

    private List<TipoPago> tipoPagoList;
}
