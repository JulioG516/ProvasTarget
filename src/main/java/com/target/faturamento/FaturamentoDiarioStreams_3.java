package com.target.faturamento;

import com.google.gson.Gson; // Ler o Json
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FaturamentoDiarioStreams_3 { // Esta classe utiliza o metodo streams introduzido no Java 8
    public static void main(String[] args) throws IOException {
        /*
        3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora,
        faça um programa, na linguagem que desejar, que calcule e retorne:
• O     menor valor de faturamento ocorrido em um dia do mês;
• O     maior valor de faturamento ocorrido em um dia do mês;
• N     número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
         */


        // Ler o arquivo JSON
        Path path = Paths.get("src/main/java/com/target/faturamento/dados.json");
        String json = Files.readString(path);

        // Converter o JSON para uma lista de objetos DiaFaturamento
        Type listType = new TypeToken<List<DiaFaturamento_3>>() {}.getType();
        List<DiaFaturamento_3> faturamentoMensal = new Gson().fromJson(json, listType);

        // Calcular o menor valor de faturamento ocorrido em um dia do mês
        double menorValor = faturamentoMensal.stream()
                .mapToDouble(DiaFaturamento_3::getValor)
                .min()
                .orElseThrow(() -> new RuntimeException("Não foi possível calcular o menor valor"));

        // Calcular o maior valor de faturamento ocorrido em um dia do mês
        double maiorValor = faturamentoMensal.stream()
                .mapToDouble(DiaFaturamento_3::getValor)
                .max()
                .orElseThrow(() -> new RuntimeException("Não foi possível calcular o maior valor"));

        // Calcular a média mensal de faturamento
        OptionalDouble mediaMensal = faturamentoMensal.stream()
                .mapToDouble(DiaFaturamento_3::getValor)
                .average();

        // Verificar o número de dias em que o valor de faturamento diário foi superior à média mensal
        int numDiasAcimaMedia = faturamentoMensal.stream()
                .filter(dia -> dia.getValor() > mediaMensal.getAsDouble())
                .collect(Collectors.toList())
                .size();

        // Imprimir os resultados
        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média mensal: " + numDiasAcimaMedia);



    }





}
