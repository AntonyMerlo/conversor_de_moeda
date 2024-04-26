package com.example;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Consulta {
    //chave da API
    private String chave = "Definir_api_key";

    public Moeda busca(String moeda_a){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/latest/" + moeda_a);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(endereco)
              .build();

        try {
            HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moeda.class);
            
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível fazer a consulta.");
        }
    }
}
