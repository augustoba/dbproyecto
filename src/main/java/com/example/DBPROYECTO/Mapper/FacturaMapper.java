package com.example.DBPROYECTO.Mapper;

import com.example.DBPROYECTO.entities.Factura;
import com.example.DBPROYECTO.dto.Response.FacturaResponseDTO;
import com.example.DBPROYECTO.dto.request.FacturaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FacturaMapper {
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "liga.nombre", source = "liga")
    @Mapping(target = "pais.nombre", source = "pais")

    Factura toFacturaEntity(FacturaRequest facturaRequest);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "liga", source = "liga.nombre")
    @Mapping(target = "pais", source = "pais.nombre")
    FacturaResponseDTO toFacturaResponseDTO(Factura factura);

}
