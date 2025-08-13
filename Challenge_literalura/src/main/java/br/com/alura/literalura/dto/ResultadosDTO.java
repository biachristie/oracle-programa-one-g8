package br.com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ResultadosDTO(
        @JsonProperty("results") List<LivroDTO> livros
) {}
