package forumhub.api.dto.categoria;

import forumhub.api.domain.Categoria;

public record CategoriaDTO(
        Long id,
        String nome
) {

    public CategoriaDTO(Categoria categoria) {
        this(
                categoria.getId(),
                categoria.getNome()
        );
    }

}
