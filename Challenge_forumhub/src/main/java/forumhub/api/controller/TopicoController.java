package forumhub.api.controller;

import forumhub.api.dto.topico.DadosAtualizacaoTopicoDto;
import forumhub.api.dto.topico.DadosCadastroTopicoDto;
import forumhub.api.dto.topico.DadosListagemTopicoDto;
import forumhub.api.dto.topico.TopicoDetalhadoDto;
import forumhub.api.service.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoDetalhadoDto> cadastrar(@RequestBody @Valid DadosCadastroTopicoDto dados, UriComponentsBuilder uriBuilder) {
        var topicoDTO = topicoService.cadastrar(dados);

        URI uri = uriBuilder.path("/topicos/{id}")
                    .buildAndExpand(topicoDTO.id())
                    .toUri();

        return ResponseEntity.created(uri).body(topicoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicoDto>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        Page<DadosListagemTopicoDto> pagina = topicoService.listarPaginado(paginacao);

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalhadoDto> detalhar(@PathVariable Long id) {
        var topicoDetalhado = topicoService.detalhar(id);

        return ResponseEntity.ok(topicoDetalhado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDetalhadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopicoDto dados) {
        var topicoAtualizado = topicoService.atualizar(id, dados);

        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
