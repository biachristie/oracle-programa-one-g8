package br.com.alura.ecomart.controller;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Não está funcionando!
@RestController
@RequestMapping("imagem")
public class GeradorDeImagensController {

    private final ImageModel imageModel;

    public GeradorDeImagensController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping
    public String gerarImagem() {
        var prompt = "Gere uma imagem de um banana";

        var options = ImageOptionsBuilder.builder()
                .height(1024)
                .width(1024)
                .build();

        var response = this.imageModel.call(new ImagePrompt(prompt, options));

        return response.getResult().getOutput().getUrl().toString();
    }
}
