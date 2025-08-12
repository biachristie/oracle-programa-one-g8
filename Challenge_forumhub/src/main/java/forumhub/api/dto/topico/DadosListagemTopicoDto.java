package forumhub.api.dto.topico;

import forumhub.api.domain.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopicoDto(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        String status,
        String autor,
        String curso
) {

public DadosListagemTopicoDto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getDataAtualizacao(),
                topico.getStatus().toString(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        );
    }

}
