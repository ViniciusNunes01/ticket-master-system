package io.github.viniciusnunes01.ticketmastersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.viniciusnunes01.ticketmastersystem.model.Estado;
import io.github.viniciusnunes01.ticketmastersystem.model.Pais;
import io.github.viniciusnunes01.ticketmastersystem.repository.EstadoRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.PaisRepository;

@Configuration
public class CargaDeDados {

	@Bean
	CommandLineRunner executarCargaInicial(PaisRepository paisRepository, EstadoRepository estadoRepository) {

		return args -> {

			paisRepository.deleteAll();
			estadoRepository.deleteAll();

			var brasil = new Pais("Brasil", "BR");
			brasil = paisRepository.save(brasil);

			var eua = new Pais("Estados Unidos", "US");
			eua = paisRepository.save(eua);

			var saoPaulo = new Estado("São Paula", "SP", brasil);
			var rio = new Estado("Rio de Janeiro", "RJ", brasil);
			var florida = new Estado("Florida", "FL", eua);

			saoPaulo = estadoRepository.save(saoPaulo);
			rio = estadoRepository.save(rio);
			florida = estadoRepository.save(florida);

			System.out.println("sucesso!");
		};
	}

}