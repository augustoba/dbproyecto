package com.example.DBPROYECTO.Mapper;

import com.example.DBPROYECTO.entities.Cliente;
import com.example.DBPROYECTO.dto.request.ClienteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toEntity(ClienteRequest clienteRequest);

    ClienteRequest toDto(Cliente cliente);

}
