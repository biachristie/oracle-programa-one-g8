package br.com.alura.conversor.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumoApi {

    private final HttpClient cliente;
    private static final Logger logger = LoggerFactory.getLogger(ConsumoApi.class);

    public ConsumoApi(HttpClient cliente) {
        this.cliente = cliente;
    }

    public String obterDados(String codigoBase, String codigoAlvo, Double valor) {
        final String ENDERECO = "https://v6.exchangerate-api.com/v6/";

        Dotenv dotenv = Dotenv.load();
        final String API_KEY = dotenv.get("EXCHANGE_API_KEY");

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(ENDERECO + API_KEY + "/pair/" + codigoBase + "/" + codigoAlvo + "/" + valor))
                .header("Accept", "application/json")
                .build();

        try {
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());


            if (resposta.statusCode() >= 400) {
                logger.error("Erro ao buscar dados na API. Status: {}, Corpo: {}", resposta.statusCode(), resposta.body());
                throw new RuntimeException("Erro na API. Código de status: " + resposta.statusCode());
            }

            logger.debug("Corpo da resposta recebida: {}", resposta.body());

            return resposta.body();
        } catch (IOException | InterruptedException e) {
            logger.error("Erro ao realizar a requisição para a API.", e);
            throw new RuntimeException("Não foi possível conectar à API: " + e.getMessage(), e);
        }
    }

}