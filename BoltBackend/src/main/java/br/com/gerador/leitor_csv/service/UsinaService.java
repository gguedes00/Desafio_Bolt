package br.com.gerador.leitor_csv.service;

import br.com.gerador.leitor_csv.dto.UsinaDTO;
import br.com.gerador.leitor_csv.repository.UsinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsinaService {

    private final UsinaRepository repository;

    public List<UsinaDTO> buscarTop5() {
        return repository.buscarTop5().stream()
                .map(usina -> new UsinaDTO(
                        usina.getNomeEmpreendimento(),
                        usina.getPotenciaOrtorgadaKm(),
                        usina.getUf(),
                        usina.getModeloUsina()
                ))
                .toList();
    }
}
