package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorSevice autorSevice;

    public LivroService(LivroRepository livroRepository, AutorSevice autorSevice) {
        this.livroRepository = livroRepository;
        this.autorSevice = autorSevice;
    }

    @Transactional
    public void salvarLivro(LivroDTO livroDto) {
        Optional<Livro> livroExistente = livroRepository.findByGutendexId(livroDto.gutendexId());

        if (livroExistente.isPresent()) {
            System.out.println("O livro " + livroDto.titulo() + " já existe no banco de dados.");
            return;
        }

        List<Autor> autores = livroDto.autores().stream()
                .map(autorSevice::findOrCreateAutor)
                .collect(Collectors.toList());

        Livro novoLivro = new Livro();
        novoLivro.setGutendexId(livroDto.gutendexId());
        novoLivro.setTitulo(livroDto.titulo());
        novoLivro.setIdiomas(livroDto.idiomas());
        novoLivro.setDownloads(livroDto.downloads());
        novoLivro.setAutores(autores);

        System.out.println("Salvando livro...");
        livroRepository.save(novoLivro);
        System.out.println("Livro " + novoLivro.getTitulo() + " salvo com sucesso.");
    }

    @Transactional
    public List<Livro> listarLivros() { return livroRepository.findAll(); }

    public List<Livro> buscarLivroPorIdioma(String idioma) {
        return livroRepository.findByIdiomasContaining(idioma);
    }

}