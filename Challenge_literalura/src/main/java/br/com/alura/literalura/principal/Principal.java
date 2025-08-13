package br.com.alura.literalura.principal;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.service.AutorSevice;
import br.com.alura.literalura.service.ConversaoDados;
import br.com.alura.literalura.service.LivroService;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConversaoDados conversaoDados;
    private LivroService livroService;
    private AutorSevice autorSevice;

    public Principal(ConversaoDados conversaoDados, LivroService livroService, AutorSevice autorSevice) {
        this.conversaoDados = conversaoDados;
        this.livroService = livroService;
        this.autorSevice = autorSevice;
    }

    public void exibeMenu() {
        int opcao = -1;

        do {
            var menu = """
                    --------------------------------------------------------
                                           LITERALURA
                    --------------------------------------------------------
                    
                    Escolha uma das opções abaixo:
                    
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar livros em um determinado idioma
                    4 - Listar autores registrados
                    5 - Listar autores vivos em um determinado ano
                    0 - Sair
                    
                    --------------------------------------------------------
                    
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroGutendex();
                    break;
                case 2:
                    buscarTodosLivrosRegistrados();
                    break;
                case 3:
                    buscarLivrosRegistradosPorIdioma();
                    break;
                case 4:
                    buscarAutoresRegistrados();
                    break;
                case 5:
                    buscarAutoresVivosEmAno();
                    break;
                case 0:
                    System.out.println("\nEncerrando o LiterAlura...\n");
                    break;
            }

        } while (opcao != 0);
    }

    private void buscarLivroGutendex() {
        System.out.println("\nInsira o nome do livro que deseja procurar: ");
        var livro = leitura.nextLine().toLowerCase();

        try {
            LivroDTO livroApi = conversaoDados.realizarConversao(livro);

            if (livroApi != null) {
                livroService.salvarLivro(livroApi);
            } else {
                System.out.println("Livro não encontrado.");
            }
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro ao buscar o livro: " + e.getMessage());
        }
    }

    private void buscarTodosLivrosRegistrados() {
        List<Livro> livrosRegistrados = livroService.listarLivros();

        imprimirListaDeLivros(livrosRegistrados, "\n--------------------------------------------- LIVROS REGISTRADOS -----------------------------------------------");
    }

    private void buscarLivrosRegistradosPorIdioma() {
        System.out.println("""
                
                Digite o idioma para busca:
                en - inglês
                es - espanhol
                fr - francês
                pt - português
                """);
        var idiomaEscolhido = leitura.nextLine();

        List<Livro> livrosPorIdioma = livroService.buscarLivroPorIdioma(idiomaEscolhido);

        imprimirListaDeLivros(livrosPorIdioma, "\n---------------------------------------------- LIVROS ENCONTRADOS ----------------------------------------------");
    }

    private void buscarAutoresRegistrados() {
        List<Autor> autoresRegistrados = autorSevice.listarAutores();

        imprimirListaDeAutores(autoresRegistrados, "\n--------------------------------------------------- AUTORES REGISTRADOS ----------------------------------------------------");
    }

    private void buscarAutoresVivosEmAno() {
        System.out.println("\nDigite o ano para busca de autores vivos: ");

        try {
            var anoBusca = leitura.nextInt();
            leitura.nextLine();

            List<Autor> autoresVivos = autorSevice.buscarAutoresVivosEmAno(anoBusca);

            imprimirListaDeAutores(autoresVivos, "\n--------------------------------------------------- AUTORES ENCONTRADOS ----------------------------------------------------");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um ano válido.");
            leitura.nextLine();
        }

    }

    private void imprimirListaDeLivros(List<Livro> livros, String cabecalho) {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro encontrado no banco de dados.");

            return;
        }

        System.out.println(cabecalho);
        System.out.printf("%-50s %-35s %-10s %-10s%n", "TÍTULO", "AUTOR", "IDIOMA", "DOWNLOADS");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        for(Livro l : livros) {
            String titulo = truncar(l.getTitulo(), 45);
            String autor = (l.getAutores() != null && !l.getAutores().isEmpty())
                    ? truncar(l.getAutores().get(0).getNome(), 30)
                    : "N/A";
            String idioma = (l.getIdiomas() != null && !l.getIdiomas().isEmpty())
                    ? l.getIdiomas().get(0)
                    : "N/A";

            System.out.printf("%-50s %-35s %-10s %-10d%n",
                    titulo,
                    autor,
                    idioma,
                    l.getDownloads());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------\n");
    }

    private void imprimirListaDeAutores(List<Autor> autores, String cabecalho) {
        if (autores.isEmpty()) {
            System.out.println("\nNenhum autor encontrado no banco de dados.");

            return;
        }

        System.out.println(cabecalho);
        System.out.printf("%-40s %-20s %-20s %-40s%n", "AUTOR", "ANO NASCIMENTO", "ANO FALECIMENTO", "LIVROS");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        for(Autor a : autores) {
            String nome = truncar(a.getNome(), 35);
            String anoNascimento = a.getAnoNascimento() != null
                    ? a.getAnoNascimento().toString()
                    : "N/A";
            String anoFalecimento = a.getAnoFalecimento() != null
                    ? a.getAnoFalecimento().toString()
                    : "N/A";
            String livros = a.getLivros().stream()
                            .map(Livro::getTitulo)
                                    .collect(Collectors.joining(", "));

            System.out.printf("%-40s %-20s %-20s %-40s%n",
                    nome,
                    anoNascimento,
                    anoFalecimento,
                    truncar(livros, 35)
                    );
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------\n");
    }

    private String truncar(String texto, int tamanhoMaximo) {
        if (texto.length() <= tamanhoMaximo) {
            return texto;
        }

        return texto.substring(0, tamanhoMaximo) + "...";
    }

}