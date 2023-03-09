package com.target.faturamento;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FaturamentoDiario_3 {        // Esta classe utiliza meios como loops para ser resolvido
    public static void main(String[] args) throws IOException {
        /*
        3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora,
        faça um programa, na linguagem que desejar, que calcule e retorne:
        menor valor de faturamento ocorrido em um dia do mês;
        maior valor de faturamento ocorrido em um dia do mês;
        número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
         */


        // Ler o arquivo JSON com os dados do faturamento mensal
        String json = new String(Files.readAllBytes(Paths.get("src/main/java/com/target/faturamento/dados.json")));
        JsonArray faturamentoArray = JsonParser.parseString(json).getAsJsonArray();

        // Calcular o menor e maior valor de faturamento diário
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        for (JsonElement elem : faturamentoArray) {
            JsonObject faturamento = elem.getAsJsonObject();
            double valor = faturamento.get("valor").getAsDouble();
            if (valor < menorValor) {
                menorValor = valor;
            }
            if (valor > maiorValor) {
                maiorValor = valor;
            }
        }


        // Calcular a média mensal de faturamento diário
        double soma = 0;
        for (JsonElement elem : faturamentoArray) {
            JsonObject faturamento = elem.getAsJsonObject();
            soma += faturamento.get("valor").getAsDouble();
        }
        double media = soma / faturamentoArray.size();

        // Contar o número de dias com faturamento diário acima da média mensal
        int numDiasAcimaDaMedia = 0;
        for (JsonElement elem : faturamentoArray) {
            JsonObject faturamento = elem.getAsJsonObject();
            if (faturamento.get("valor").getAsDouble() > media) {
                numDiasAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento diário: " + menorValor);
        System.out.println("Maior valor de faturamento diário: " + maiorValor);
        System.out.println("Número de dias com faturamento diário acima da média mensal: " + numDiasAcimaDaMedia);


    }



}
