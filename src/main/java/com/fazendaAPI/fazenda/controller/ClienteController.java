package com.fazendaAPI.fazenda.controller;

import com.fazendaAPI.fazenda.model.Animal;
import com.fazendaAPI.fazenda.model.Cliente;
import com.fazendaAPI.fazenda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){

        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getByID(@PathVariable Long id){
        Cliente cliente = clienteService.SearchByID(id);
        return ResponseEntity.ok(cliente);
    }

    // Metodo para inserir o cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        Cliente Newcliente = clienteService.InsertCustomer(cliente);
        return ResponseEntity.ok(Newcliente);
    }

    // Metodo para Actualizar o cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteUp){

        Cliente clienteby = clienteService.SearchByID(id);
        clienteby.setNome(clienteUp.getNome());
        clienteby.setEndereco(clienteUp.getEndereco());
        clienteby.setTelefone(clienteUp.getTelefone());
        clienteby.setEmail(clienteUp.getEmail());
        clienteby.setUpdatedAt(clienteUp.getUpdatedAt());

        Cliente clienteSalvo = clienteService.InsertCustomer(clienteby);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
