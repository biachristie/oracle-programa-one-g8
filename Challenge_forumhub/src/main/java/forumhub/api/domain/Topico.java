package forumhub.api.domain;

import forumhub.api.infra.exception.RegraDeNegocioException;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_topico_titulo_mensagem", columnNames = {"titulo", "mensagem"})
})
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String mensagem;

    @Column(name = "data_criacao", updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TopicoStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = this.dataCriacao;
        this.status = TopicoStatus.ABERTO;
    }

    public void atualizarInformacoes(String novoTitulo, String novaMensagem) {
        if (novoTitulo != null && !novoTitulo.isBlank()) {
            this.titulo = novoTitulo;
        }

        if (novaMensagem != null && !novaMensagem.isBlank()) {
            this.mensagem = novaMensagem;
        }

        this.dataAtualizacao = LocalDateTime.now();
    }

    public void adicionaResposta(Resposta resposta) {
        if (this.status == TopicoStatus.FECHADO) {
            throw new RegraDeNegocioException("Não é possível responder um tópico fechado.");
        }

        this.respostas.add(resposta);
        resposta.setTopico(this);
    }

    public void fechar() {
        this.status = TopicoStatus.FECHADO;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public List<Resposta> getRespostas() {
        return Collections.unmodifiableList(respostas);
    }

}
