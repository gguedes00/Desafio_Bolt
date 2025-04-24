package br.com.gerador.leitor_csv.controller;

import br.com.gerador.leitor_csv.dto.UsinaDTO;
import br.com.gerador.leitor_csv.service.UsinaService;
import br.com.gerador.leitor_csv.service.LeitorCsvService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usina")
@AllArgsConstructor
public class UsinaController {

    private final LeitorCsvService leitorCsvService;
    private final UsinaService usinaService;

    @GetMapping("/top5")
    public ResponseEntity<List<UsinaDTO>> listarTop5() {
        List<UsinaDTO> top5 = usinaService.buscarTop5();
        return ResponseEntity.status(HttpStatus.OK).body(top5);
    }
}
