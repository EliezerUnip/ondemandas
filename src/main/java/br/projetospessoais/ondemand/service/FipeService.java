package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.dto.MarcaDto;
import br.projetospessoais.ondemand.dto.ModeloDto;
import br.projetospessoais.ondemand.dto.ModeloResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FipeService {

    private final String URL = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

    public MarcaDto[] buscarMarcas() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MarcaDto[]> response =
                restTemplate.getForEntity(URL, MarcaDto[].class);

        return response.getBody();
    }

    public List<ModeloDto> buscarModelos(String marcaId) {

        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/"
                + marcaId + "/modelos";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ModeloResponseDto> response =
                restTemplate.getForEntity(url, ModeloResponseDto.class);

        return response.getBody().getModelos();
    }
}

