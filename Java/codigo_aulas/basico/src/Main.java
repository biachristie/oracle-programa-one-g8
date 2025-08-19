
public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match!");
        System.out.println("Filme: Top Gun: Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento: " + anoDeLancamento);

        boolean incluidoNoPlano = false;

        double NotaDoFilme = 8.1;

        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println(media);

        String sinopse = """
        Filme Top Gun
        Filme de aventura com galã dos anos 80
        Ano de lançamento : """ + anoDeLancamento;
        System.out.println(sinopse);

        //CASTING: recurso utilizado em Java para converter um tipo de dado em outro
        int classificacao = (int) (media / 2);
        System.out.println(classificacao);
    }
}