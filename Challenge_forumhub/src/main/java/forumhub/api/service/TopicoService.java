package forumhub.api.service;

import forumhub.api.domain.Curso;
import forumhub.api.domain.Topico;
import forumhub.api.domain.Usuario;
import forumhub.api.dto.topico.DadosAtualizacaoTopicoDto;
import forumhub.api.dto.topico.DadosCadastroTopicoDto;
import forumhub.api.dto.topico.DadosListagemTopicoDto;
import forumhub.api.dto.topico.TopicoDetalhadoDto;
import forumhub.api.infra.exception.RegraDeNegocioException;
import forumhub.api.repository.CursoRepository;
import forumhub.api.repository.TopicoRepository;
import forumhub.api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Transactional
    public TopicoDetalhadoDto cadastrar(DadosCadastroTopicoDto dados) {
        if (topicoRepository.findByTituloAndMensagem(dados.titulo(), dados.mensagem()).isPresent()) {
            throw new IllegalArgumentException("Tópico com o mesmo título e mensagem já existe");
        }

        Usuario autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado."));

        Curso curso = cursoRepository.findById(dados.idCurso())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado."));

        Topico topico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                autor,
                curso
        );

        topicoRepository.save(topico);

        return new TopicoDetalhadoDto(topico);
    }

    public Page<DadosListagemTopicoDto> listarPaginado(Pageable paginacao) {
        Page<Topico> paginaTopicos = topicoRepository.findAll(paginacao);

        return paginaTopicos.map(DadosListagemTopicoDto::new);
    }

    public TopicoDetalhadoDto detalhar(Long idTopico) {
        Topico topico = topicoRepository.findById(idTopico)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado com id: " + idTopico));

        return new TopicoDetalhadoDto(topico);
    }

    @Transactional
    public TopicoDetalhadoDto atualizar(Long idTopico, DadosAtualizacaoTopicoDto dados) {
        Topico topico = topicoRepository.findById(idTopico)
                .orElseThrow(() -> new EntityNotFoundException("Tópico com ID " + idTopico + " não encontrado."));

        if (topicoRepository.findByTituloAndMensagemAndIdNot(dados.titulo(), dados.mensagem(), idTopico).isPresent()) {
            throw new RegraDeNegocioException("Já existe outro tópico com o mesmo título e mensagem");
        }

        topico.atualizarInformacoes(dados.titulo(), dados.mensagem());

        return new TopicoDetalhadoDto(topico);
    }

    @Transactional
    public void excluir(Long idTopico) {
        if (!topicoRepository.existsById(idTopico)) {
            throw new EntityNotFoundException("Tópico não encontrado com id: " + idTopico);
        }

        topicoRepository.deleteById(idTopico);
    }
}