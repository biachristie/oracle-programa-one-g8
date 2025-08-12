package forumhub.api.dto.curso;

import forumhub.api.domain.Curso;

public record CursoDTO(
        Long id,
        String nome,
        String categoria
) {

    public CursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getCategoria().getNome()
        );
    }

}
