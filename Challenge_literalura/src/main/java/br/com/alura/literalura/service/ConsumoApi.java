package br.com.alura.literalura.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class ConsumoApi {

    @Value("${API_GUTENDEX_URL}")
    private String endereco;
    private final HttpClient cliente;
    private static final Logger logger = LoggerFactory.getLogger(ConsumoApi.class);

    public ConsumoApi(HttpClient cliente) {
        this.cliente = cliente;
    }

    public String obterDados(String busca) {
        String urlCompleta = endereco + "?search=" + busca.replace(" ", "%20");

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(urlCompleta))
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