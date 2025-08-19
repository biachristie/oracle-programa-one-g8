package br.com.alura.ScreenMatch_frases.service;

import br.com.alura.ScreenMatch_frases.dto.FraseDTO;
import br.com.alura.ScreenMatch_frases.model.Frase;
import br.com.alura.ScreenMatch_frases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repositorio;

    public FraseDTO obterFraseAleatoria() {
        Frase frase = repositorio.buscaFraseAleatoria();

        return new FraseDTO(frase.getFrase(), frase.getTitulo(), frase.getPersonagem(), frase.getPoster());
    }
}
