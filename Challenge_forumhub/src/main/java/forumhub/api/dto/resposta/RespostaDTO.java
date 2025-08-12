package forumhub.api.dto.resposta;

import com.fasterxml.jackson.annotation.JsonFormat;
import forumhub.api.domain.Resposta;

import java.time.LocalDateTime;

public record RespostaDTO(
        Long id,
        String mensagem,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataAtualizacao,
        String autor,
        boolean solucao
) {

    public RespostaDTO(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getDataAtualizacao(),
                resposta.getAutor().getNome(),
                resposta.getSolucao()
        );
    }

}
