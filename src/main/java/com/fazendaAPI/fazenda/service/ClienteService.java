package com.fazendaAPI.fazenda.service;

import com.fazendaAPI.fazenda.model.Cliente;
import com.fazendaAPI.fazenda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente SearchByID(Long id ){
       try {
           return clienteRepository.findById(id)
                   .orElseThrow(() -> new RuntimeException(" Cliente não encontrado" + id));
       } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
        }
    }

    public Cliente InsertCustomer(Cliente customer){return clienteRepository.save(customer);}

    public void deleteCustomer(Long id) {
        clienteRepository.deleteById(id);
    }

}
