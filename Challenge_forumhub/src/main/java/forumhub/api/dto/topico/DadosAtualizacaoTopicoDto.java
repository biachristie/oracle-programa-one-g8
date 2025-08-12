package forumhub.api.dto.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopicoDto(
        @NotBlank(message = "Título não pode ser vazio.")
        String titulo,

        @NotBlank(message = "Mensagem não pode ser vazia.")
        String mensagem
) {
}
