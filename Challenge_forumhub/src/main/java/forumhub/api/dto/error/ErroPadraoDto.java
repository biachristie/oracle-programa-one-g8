package forumhub.api.dto.error;

import java.time.Instant;

public record ErroPadraoDto(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
