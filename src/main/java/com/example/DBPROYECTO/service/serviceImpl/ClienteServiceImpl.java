package com.example.DBPROYECTO.service.serviceImpl;

import com.example.DBPROYECTO.entities.Cliente;
import com.example.DBPROYECTO.repository.ClienteRepository;
import com.example.DBPROYECTO.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void createClient(Cliente cliente){
        Cliente clienteAux;
        clienteAux=clienteRepository.findByNombreAndApellido(cliente.getNombre(),cliente.getApellido());
        if ( clienteAux == null){
            clienteRepository.save(cliente) ;
        }
    }

    @Override
    public List<Cliente> clientes(){
        return  clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id){
        return  clienteRepository.findById(id);
    }

    @Override
    public Cliente findByNameAndLastName(String nombre, String apellido){
        return clienteRepository.findByNombreAndApellido(nombre,apellido);
    }
    @Override
    public Cliente findByCuit(String cuit){
        return clienteRepository.findByCuit(cuit);
    }


}
