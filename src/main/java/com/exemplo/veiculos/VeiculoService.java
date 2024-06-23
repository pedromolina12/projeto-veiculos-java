package com.exemplo.veiculos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoService {
    private List<Veiculo> veiculos;

    public VeiculoService(String caminhoArquivoParana) throws IOException {
        ObjectMapper objectMapperParana = new ObjectMapper();
        veiculos = objectMapperParana.readValue(new File(caminhoArquivoParana), new TypeReference<List<Veiculo>>(){});
    }

    public List<Veiculo> filtrarPorMarca(String marcaCuritiba) {
        return veiculos.stream()
                .filter(veiculoLondrina -> veiculoLondrina.getMarca().equalsIgnoreCase(marcaCuritiba))
                .collect(Collectors.toList());
    }

    public int somarValorPorMarca(String marcaMaringa) {
        return veiculos.stream()
                .filter(veiculoCascavel -> veiculoCascavel.getMarca().equalsIgnoreCase(marcaMaringa))
                .mapToInt(Veiculo::getValor)
                .sum();
    }

    public List<Veiculo> filtrarPorAno(int anoPontaGrossa) {
        return veiculos.stream()
                .filter(veiculoFozDoIguacu -> veiculoFozDoIguacu.getAno() > anoPontaGrossa)
                .collect(Collectors.toList());
    }
}
