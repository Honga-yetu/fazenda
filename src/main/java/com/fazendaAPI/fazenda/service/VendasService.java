package com.fazendaAPI.fazenda.service;

import com.fazendaAPI.fazenda.DTO.VendasDTO;
import com.fazendaAPI.fazenda.model.Animal;
import com.fazendaAPI.fazenda.model.Cliente;
import com.fazendaAPI.fazenda.model.Fazenda;
import com.fazendaAPI.fazenda.model.Vendas;
import com.fazendaAPI.fazenda.repository.AnimalRepository;
import com.fazendaAPI.fazenda.repository.ClienteRepository;
import com.fazendaAPI.fazenda.repository.FazendaRepository;
import com.fazendaAPI.fazenda.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasService {

    @Autowired
    private VendasRepository saleRepository;
    @Autowired
    private FazendaRepository fazendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AnimalRepository animalRepository;

    public Vendas createSale(VendasDTO saleDTO) {
        Fazenda fazenda = fazendaRepository.findById(saleDTO.getFazenda_id())
                .orElseThrow(() -> new ResourceNotFoundException("Fazenda não encontrada"));

        Cliente cliente = clienteRepository.findById(saleDTO.getCliente_id())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Animal animal = animalRepository.findById(saleDTO.getAnimal_id())
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado"));

        Vendas sale = new Vendas();
        sale.setFazenda(fazenda);
        sale.setCliente(cliente);
        sale.setAnimal(animal);
        sale.setInvoiceDate(saleDTO.getInvoiceDate());
        saleRepository.save(sale);

        return sale;
    }


}
