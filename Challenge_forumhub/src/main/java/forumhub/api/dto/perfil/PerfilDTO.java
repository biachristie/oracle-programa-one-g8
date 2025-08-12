package forumhub.api.dto.perfil;

import forumhub.api.domain.Perfil;

public record PerfilDTO(
        Long id,
        String nome
) {

    public PerfilDTO(Perfil perfil) {
        this(
                perfil.getId(),
                perfil.getNome()
        );
    }

}
