package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.dto.ResultadosDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConversaoDados {

    private final ConsumoApi consumoApi;
    private final ObjectMapper objectMapper;

    public ConversaoDados(ConsumoApi consumoApi, ObjectMapper objectMapper) {
        this.consumoApi = consumoApi;
        this.objectMapper = objectMapper;
    }

    public LivroDTO JsonParaLivroDTO(String json) {
        try {
            ResultadosDTO resposta = objectMapper.readValue(json, ResultadosDTO.class);

            if (resposta != null && resposta.livros() != null && !resposta.livros().isEmpty()) {
                return resposta.livros().get(0);
            }

            return null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao desserializar o JSON para LivroDTO.");
        }
    }

    public LivroDTO realizarConversao(String livro) {
        var json = consumoApi.obterDados(livro);
        return JsonParaLivroDTO(json);
    }

}