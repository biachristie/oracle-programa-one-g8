package br.com.alura.screenmatch.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaGemini {
    public static String ObterTraducao(String texto) {
        Dotenv dotenv = Dotenv.load();
        String apikey = dotenv.get("GEMINI_API_KEY");

        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(apikey)
                .modelName("gemini-1.5-flash")
                .maxOutputTokens(1000)
                .temperature(0.7)
                .build();

        return gemini.generate("Traduza para português o texto: " + texto);
    }
}
