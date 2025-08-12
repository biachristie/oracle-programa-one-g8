package forumhub.api.dto.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import forumhub.api.dto.resposta.RespostaDTO;
import forumhub.api.domain.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record TopicoDetalhadoDto(
        Long id,
        String titulo,
        String mensagem,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataAtualizacao,
        String status,
        String autor,
        String curso,
        List<RespostaDTO> respostas
) {

    public TopicoDetalhadoDto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getDataAtualizacao(),
                topico.getStatus().toString(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome(),
                topico.getRespostas().stream()
                        .map(RespostaDTO::new)
                        .collect(Collectors.toList())
        );
    }

}