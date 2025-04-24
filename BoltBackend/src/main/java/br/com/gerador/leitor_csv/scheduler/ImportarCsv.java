package br.com.gerador.leitor_csv.scheduler;

import br.com.gerador.leitor_csv.service.LeitorCsvService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;


@Component
public class ImportarCsv {

    private final LeitorCsvService leitorCsvService;

    @Value("${csv.import.url}")
    private String csvUrl;

    public ImportarCsv(LeitorCsvService leitorCsvService) {
        this.leitorCsvService = leitorCsvService;
    }

    @EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
    public void importarAoIniciar() {
        importar();
    }

    @Scheduled(cron = "0 0 * * * *", zone = "America/Sao_Paulo")
    public void importarCsvPeriodicamente() {
        importar();
    }

    private void importar() {
        try {
            leitorCsvService.importarCSV(csvUrl);
            System.out.println("✅ Importação do CSV concluída.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao importar CSV: " + e.getMessage());
        }
    }
}
