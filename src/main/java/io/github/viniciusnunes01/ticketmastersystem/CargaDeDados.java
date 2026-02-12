package io.github.viniciusnunes01.ticketmastersystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.viniciusnunes01.ticketmastersystem.model.Cidade;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.model.Endereco;
import io.github.viniciusnunes01.ticketmastersystem.model.Estado;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.model.Pais;
import io.github.viniciusnunes01.ticketmastersystem.repository.CidadeRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.ClienteRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.EstadoRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.PaisRepository;

@Configuration
public class CargaDeDados {

    @Bean
    CommandLineRunner executarCargaInicial(
            PaisRepository paisRepository,
            EstadoRepository estadoRepository,
            CidadeRepository cidadeRepository,
            ClienteRepository clienteRepository,
            EventoRepository eventoRepository
    ) {
        return args -> {
            if (paisRepository.count() == 0) {
                
                var brasil = new Pais("Brasil", "BR");
                paisRepository.save(brasil);

                var saoPauloEstado = new Estado("São Paulo", "SP", brasil);
                estadoRepository.save(saoPauloEstado);

                var jundiai = new Cidade("Jundiaí", saoPauloEstado);
                cidadeRepository.save(jundiai);

                var cliente = new Cliente();
                cliente.setNome("Vinicius Nunes");
                cliente.setCpf("123.456.789-00");
                cliente.setEmail("vinicius@email.com");
                cliente.setTelefone("(11) 99999-9999");
                cliente.setDataNascimento(java.time.LocalDate.of(2000, 1, 1));
                
                var endereco = new Endereco();
                endereco.setLogradouro("Av. Paulista");
                endereco.setNumero("1000");
                endereco.setBairro("Bela Vista");
                endereco.setCep("01310-100");
                endereco.setComplemento("Apto 50");
                endereco.setCidade(jundiai);
                
                cliente.setEndereco(endereco);
                clienteRepository.save(cliente);

                var rockInRio = new Evento();
                rockInRio.setNome("Rock in Rio 2026");
                rockInRio.setData(LocalDateTime.of(2026, 9, 20, 20, 0));
                rockInRio.setCapacidadeMaxima(100);
                rockInRio.setIngressosRestantes(100);
                rockInRio.setPrecoBase(new BigDecimal("550.00"));
                
                eventoRepository.save(rockInRio);

                System.out.println("✅ Carga inicial COMPLETA: Cliente (ID 1) e Evento (ID 1) criados!");
            }
        };
    }
}