package forumhub.api.infra.exception;

import forumhub.api.dto.error.DadosErroValidacaoDto;
import forumhub.api.dto.error.ErroPadraoDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.websocket.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    private static final Logger log = LoggerFactory.getLogger(TratadorDeErros.class);

    // 400 - Erros de Validação de DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacaoDto>> tratarErroValidacao(MethodArgumentNotValidException ex, HttpServletRequest req) {
        var erros = ex.getFieldErrors();
        List<DadosErroValidacaoDto> errosDto = erros.stream()
                .map(erro -> new DadosErroValidacaoDto(erro.getField(), erro.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errosDto);
    }

    // 400 - JSON Malformado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadraoDto> tratarJsonMalFormatado(HttpMessageNotReadableException ex, HttpServletRequest req) {
        var status = HttpStatus.BAD_REQUEST;
        var erroDto = new ErroPadraoDto(
                Instant.now(),
                status.value(),
                "JSON Malformado",
                "O corpo da requisição contém um JSON malformado ou com tipo de dados inválidos.",
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroDto);
    }

    // 401 - Falha de Autenticação (Token inválido/ausente)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErroPadraoDto> tratarErroAutenticacao(AuthenticationException ex, HttpServletRequest req) {
        var status = HttpStatus.UNAUTHORIZED;
        var erroDto = new ErroPadraoDto(
                Instant.now(),
                status.value(),
                "Falha na autenticação",
                "Credenciais inválidas ou token de autenticação ausente/expirado.",
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroDto);
    }

    // 403 - Acesso Negado (Não tem permissão)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErroPadraoDto> tratarErroAcessoNegado(AccessDeniedException ex, HttpServletRequest req) {
        var status = HttpStatus.FORBIDDEN;
        var erroDto = new ErroPadraoDto(
                Instant.now(),
                status.value(),
                "Acesso negado",
                "Você não tem permissão para acessar este recurso.",
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroDto);
    }

    // 404 - Recurso Não Encontrado
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroPadraoDto> tratarErro404(EntityNotFoundException ex, HttpServletRequest req) {
        var status = HttpStatus.NOT_FOUND;
        var erroDto = new ErroPadraoDto(
                Instant.now(),
                status.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroDto);
    }

    // 409 - Conflito de Regra de Negócio
    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErroPadraoDto> tratarRegraDeNegocio(RegraDeNegocioException ex, HttpServletRequest req) {
        var status = HttpStatus.CONFLICT;
        var erroDto = new ErroPadraoDto(
                Instant.now(),
                status.value(),
                "Conflito de regra de negócio",
                ex.getMessage(),
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroDto);
    }

    // 500 - Erro Inesperado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroPadraoDto> tratarErroInesperado(Exception ex, HttpServletRequest req) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        log.error("Ocorreu um erro inesperado: ", ex);

        var erroDto = new ErroPadraoDto(
                Instant.now(),
                status.value(),
                "Erro interno do servidor",
                "Ocorreu um erro inesperado no sistema. Tente novamente mais tarde.",
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroDto);
    }

}