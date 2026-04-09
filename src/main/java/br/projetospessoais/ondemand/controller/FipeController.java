package br.projetospessoais.ondemand.controller;

import br.projetospessoais.ondemand.dto.MarcaDto;
import br.projetospessoais.ondemand.dto.ModeloDto;
import br.projetospessoais.ondemand.service.FipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/fipe/marcas")
    public MarcaDto[] listarMarcas() {
        return fipeService.buscarMarcas();
    }

    @GetMapping("/fipe/modelos/{marcaId}")
    public List<ModeloDto> listarModelos(
            @PathVariable String marcaId,
            @RequestParam(required = false) String nome) {

        List<ModeloDto> modelos = fipeService.buscarModelos(marcaId);

        if (nome != null) {
            return modelos.stream()
                    .filter(m -> m.getNome().toLowerCase().contains(nome.toLowerCase()))
                    .toList();
        }

        return modelos;
    }
}
