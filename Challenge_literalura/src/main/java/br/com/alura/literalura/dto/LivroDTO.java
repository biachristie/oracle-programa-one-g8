package br.com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonProperty("id") Long gutendexId,
        @JsonProperty("title") String titulo,
        @JsonProperty("authors") List<AutorDTO> autores,
        @JsonProperty("languages") List<String> idiomas,
        @JsonProperty("download_count") int downloads
) {}
