package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.AutorDTO;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorSevice {

    private final AutorRepository autorRepository;

    public AutorSevice(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor findOrCreateAutor(AutorDTO autorDto) {
        String nomeFormatado = formatarNomeAutor(autorDto.nome());

        Optional<Autor> autorExistente = autorRepository.findByNome(nomeFormatado);

        return autorExistente.orElseGet(() -> {
            Autor novoAutor = new Autor();

            novoAutor.setNome(nomeFormatado);
            novoAutor.setAnoNascimento(autorDto.anoNascimento());
            novoAutor.setAnoFalecimento(autorDto.anoFalecimento());

            return novoAutor;
        });
    }

    private String formatarNomeAutor(String nomeOriginal) {
        if (nomeOriginal.contains(",")) {
            String[] partes = nomeOriginal.split(", ");

            if (partes.length >= 2) { return partes[1] + " " + partes[0]; }
        }

        return nomeOriginal;
    }

    public List<Autor> listarAutores() {
        return autorRepository.buscarTodosComLivros();
    }

    public List<Autor> buscarAutoresVivosEmAno(Integer ano) {
        return autorRepository.findAutoresVivosEmAno(ano);
    }

}
