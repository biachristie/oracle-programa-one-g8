package forumhub.api.dto.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopicoDto(
        @NotBlank(message = "Título é obrigatório.")
        String titulo,

        @NotBlank(message = "Mensagem é obrigatória.")
        String mensagem,

        @NotNull(message = "Id do autor é obrigatório.")
        Long idAutor,

        @NotNull(message = "Id do curso é obrigatório.")
        Long idCurso
) {
}
