package br.com.gerador.leitor_csv.service;

import br.com.gerador.leitor_csv.model.Usina;
import br.com.gerador.leitor_csv.repository.UsinaRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@Service
@AllArgsConstructor
public class LeitorCsvService {

    private final UsinaRepository usinaRepository;

    public void importarCSV(String urlCsv) throws IOException {
        usinaRepository.deleteAll();

        URL url = new URL(urlCsv);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withDelimiter(';')
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {

            for (CSVRecord csvRecord : csvParser) {
                Usina usina = new Usina();
                usina.setUf(csvRecord.get("SigUFPrincipal"));
                usina.setModeloUsina(csvRecord.get("SigTipoGeracao"));
                usina.setCnpjEmpresa(csvRecord.get("NumCnpjEmpresaConexao"));
                usina.setFonteCombustivel(csvRecord.get("DscOrigemCombustivel"));
                usina.setNomeEmpreendimento(csvRecord.get("NomEmpreendimento"));
                String potenciaString = csvRecord.get("MdaPotenciaOutorgadaKw").replace(",", ".");
                Double potencia = Double.valueOf(potenciaString);
                usina.setPotenciaOrtorgadaKm(potencia);
                usinaRepository.save(usina);
            }
        }
    }

}
